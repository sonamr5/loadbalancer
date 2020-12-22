package com.milkbasket.rest.services.loadbalancer;

/**
 * @author sonamrathore
 *
 */
public class ApplicationLoadBalancerProcessor extends LoadBalancerProcessor {
	public ApplicationLoadBalancerProcessor(LoadBalancingAlgo loadBalancingAlgo) {
		this.loadBalancingAlgo = loadBalancingAlgo;
		this.routingAlgo = new ApplicationRoutingAlgo();
	}
}
