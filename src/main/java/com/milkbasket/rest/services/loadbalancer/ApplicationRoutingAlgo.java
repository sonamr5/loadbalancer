package com.milkbasket.rest.services.loadbalancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonamrathore
 *
 */
public class ApplicationRoutingAlgo implements RoutingAlgo {
	private Map<String, ServiceListener> pathToServiceBeanMap = new HashMap<String, ServiceListener>();


	public ServiceListener getServiceListner(String url, String port) {
		// TODO Auto-generated method stub
		return pathToServiceBeanMap.get(url);
	}


	public void addService(String port, ServiceListener serviceListener) {
		pathToServiceBeanMap.put(port, serviceListener);
	}

	public void removeService(String port, String serverIp) {
		final ServiceListener serviceListener = pathToServiceBeanMap.get(port);
		if (serviceListener != null) {
			serviceListener.removeService(serverIp);
		}
	}
}
