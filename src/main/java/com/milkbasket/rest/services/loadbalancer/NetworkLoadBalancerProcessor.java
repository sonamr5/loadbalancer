package com.milkbasket.rest.services.loadbalancer;

/**
 * @author sonamrathore
 *
 */
public class NetworkLoadBalancerProcessor extends LoadBalancerProcessor {

	public NetworkLoadBalancerProcessor(LoadBalancingAlgo loadBalancingAlgo) {
		this.loadBalancingAlgo = loadBalancingAlgo;
		this.routingAlgo = new NetworkRoutingAlgo();
	}


}
