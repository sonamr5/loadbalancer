package com.milkbasket.rest.services.loadbalancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonamrathore
 *
 */
public class NetworkRoutingAlgo implements RoutingAlgo {
	private Map<String, ServiceListener> portToServiceBeanMap = new HashMap<String, ServiceListener>();

	public ServiceListener getServiceListner(String path, String port) {
		return portToServiceBeanMap.get(port);
	}

	public void addService(String port, ServiceListener serviceListener) {
		portToServiceBeanMap.put(port, serviceListener);

	}

	public void removeService(String port, String serverIp) {
		final ServiceListener serviceListener = portToServiceBeanMap.get(port);
		if (serviceListener != null) {
			serviceListener.removeService(serverIp);
		}
	}
}
