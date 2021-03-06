/*
 * Kubernetes
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1.8.11
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.kubernetes.client.models;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.kubernetes.client.models.V1alpha1ServiceReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * AdmissionHookClientConfig contains the information to make a TLS connection with the webhook
 */
@ApiModel(description = "AdmissionHookClientConfig contains the information to make a TLS connection with the webhook")

public class V1alpha1AdmissionHookClientConfig {
  @SerializedName("caBundle")
  private byte[] caBundle = null;

  @SerializedName("service")
  private V1alpha1ServiceReference service = null;

  public V1alpha1AdmissionHookClientConfig caBundle(byte[] caBundle) {
    this.caBundle = caBundle;
    return this;
  }

   /**
   * CABundle is a PEM encoded CA bundle which will be used to validate webhook&#39;s server certificate. Required
   * @return caBundle
  **/
  @ApiModelProperty(required = true, value = "CABundle is a PEM encoded CA bundle which will be used to validate webhook's server certificate. Required")
  public byte[] getCaBundle() {
    return caBundle;
  }

  public void setCaBundle(byte[] caBundle) {
    this.caBundle = caBundle;
  }

  public V1alpha1AdmissionHookClientConfig service(V1alpha1ServiceReference service) {
    this.service = service;
    return this;
  }

   /**
   * Service is a reference to the service for this webhook. If there is only one port open for the service, that port will be used. If there are multiple ports open, port 443 will be used if it is open, otherwise it is an error. Required
   * @return service
  **/
  @ApiModelProperty(required = true, value = "Service is a reference to the service for this webhook. If there is only one port open for the service, that port will be used. If there are multiple ports open, port 443 will be used if it is open, otherwise it is an error. Required")
  public V1alpha1ServiceReference getService() {
    return service;
  }

  public void setService(V1alpha1ServiceReference service) {
    this.service = service;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1alpha1AdmissionHookClientConfig v1alpha1AdmissionHookClientConfig = (V1alpha1AdmissionHookClientConfig) o;
    return Objects.equals(this.caBundle, v1alpha1AdmissionHookClientConfig.caBundle) &&
        Objects.equals(this.service, v1alpha1AdmissionHookClientConfig.service);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caBundle, service);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1alpha1AdmissionHookClientConfig {\n");
    
    sb.append("    caBundle: ").append(toIndentedString(caBundle)).append("\n");
    sb.append("    service: ").append(toIndentedString(service)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

