package com.milkbasket.rest.services.loadbalancer;

/**
 * @author sonamrathore
 *
 */
public interface LoadBalancingAlgo {
	int findNextServer(int totalSize, int lastServerIndex);
}
