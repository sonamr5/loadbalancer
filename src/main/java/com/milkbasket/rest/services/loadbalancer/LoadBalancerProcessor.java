package com.milkbasket.rest.services.loadbalancer;

import com.google.gson.JsonObject;

/**
 * @author sonamrathore
 *
 */
public abstract class LoadBalancerProcessor {

	protected RoutingAlgo routingAlgo;
	protected LoadBalancingAlgo loadBalancingAlgo;

	public JsonObject processRequest(String url, String port, JsonObject requestBody, String headers, String httpMethod) {
		final ServiceListener serviceListener = routingAlgo.getServiceListner(url, port);
		final String serverIpString = serviceListener.getServerIp(loadBalancingAlgo);
		return callService(url, requestBody, headers, httpMethod, serverIpString);
	}

	public JsonObject callService(String url, JsonObject requestBody, String headers, String httpMethod, String serverIpString) {
		return new JsonObject();
	}

	public void addService(String port, ServiceListener serviceListener) {
		this.routingAlgo.addService(port, serviceListener);
	}

	public void removeService(String port, String serverIp) {
		this.routingAlgo.removeService(port, serverIp);
	}

}
