package com.milkbasket.rest.services.loadbalancer;

/**
 * @author sonamrathore
 *
 */
public interface ServiceListener {
	String getServerIp(LoadBalancingAlgo algo);

	void removeService(String serverIp);
}
