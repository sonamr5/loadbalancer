package com.milkbasket.rest.services.loadbalancer;

/**
 * @author sonamrathore
 *
 */
public interface RoutingAlgo {
	ServiceListener getServiceListner(String path, String port);

	void addService(String port, ServiceListener serviceListener);

	void removeService(String port, String serverIp);
}
