/*
Copyright 2017 The Kubernetes Authors.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package io.kubernetes.client.examples;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Node;
import io.kubernetes.client.models.V1NodeList;
import io.kubernetes.client.util.Config;

/** A simple example of how to use Watch API to watch changes in Namespace list. */
public class WatchExample {
  public static void main(String[] args) throws IOException, ApiException {
    ApiClient client = Config.defaultClient();
    client.getHttpClient().setReadTimeout(60, TimeUnit.SECONDS);
    Configuration.setDefaultApiClient(client);

    CoreV1Api api = new CoreV1Api(client);

//    Watch<V1Namespace> watch =
//        Watch.createWatch(
//            client,
//            api.listNamespaceCall(
//                null, null, null, null, null, 5, null, null, Boolean.TRUE, null, null),
//            new TypeToken<Watch.Response<V1Namespace>>() {}.getType());
//
//    for (Watch.Response<V1Namespace> item : watch) {
//      System.out.printf("%s : %s%n", item.type, item.object.getMetadata().getName());
//    }
    
    V1NodeList nodeList = null;
    try {
    	nodeList = api.listNode("true", null, null, null, null, null, null, null, null);
            for (V1Node node : nodeList.getItems()) {
            	Map<String, String>  map = node.getMetadata().getLabels();
            	// Map<String, List<String>> deviceMap = new HashMap<>();
            	System.out.println(new Gson().toJson(map));
            	for (Map.Entry<String, String> entry : map.entrySet()) {
            		//if(entry.getKey().indexOf("hostname") > -1 || entry.getKey().indexOf("network-device") > -1) {
            			//System.out.println(entry.getKey() + " : " + entry.getValue());
            		//}
            	}
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
  }
}
