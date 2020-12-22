package com.milkbasket.rest.services.loadbalancer;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class App
{
	public static void main(String[] args) {
		final LoadBalancingAlgo loadBalancingAlgo = new RoundRobinLoadBalancingAlgo();
		final LoadBalancerProcessor processor = new NetworkLoadBalancerProcessor(loadBalancingAlgo);

		final List<String> serverIpsList = new ArrayList<String>();
		serverIpsList.add("75.91.8.9");
		serverIpsList.add("76.90.8.1");
		serverIpsList.add("76.90.8.2");
		final ServiceListener serviceListener = new ConsumerServiceListener(serverIpsList);
		processor.addService("9091", serviceListener);

		for (int i = 0; i < 4; i++) {
			processor.processRequest("/consumer/add", "9091", new JsonObject(), "", "POST");
		}

	}
}
