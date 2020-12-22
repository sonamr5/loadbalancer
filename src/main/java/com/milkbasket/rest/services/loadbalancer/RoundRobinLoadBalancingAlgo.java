package com.milkbasket.rest.services.loadbalancer;

/**
 * @author sonamrathore
 *
 */
public class RoundRobinLoadBalancingAlgo implements LoadBalancingAlgo {

	public int findNextServer(int totalSize, int lastServerIndex) {

		return (lastServerIndex + 1) % totalSize;

	}

}
