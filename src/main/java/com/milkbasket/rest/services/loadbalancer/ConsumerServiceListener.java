package com.milkbasket.rest.services.loadbalancer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sonamrathore
 *
 */
public class ConsumerServiceListener implements ServiceListener {

	private List<String> serverIpList = new ArrayList<String>();
	private int size;
	private int lastServerIndex;
	private Map<String, Integer> serverToIndexMap = new HashMap<String, Integer>();

	public ConsumerServiceListener(List<String> serverIpList) {
		if (serverIpList == null) {
			throw new RuntimeException("Server list cannot be empty");
		}
		this.serverIpList = serverIpList;
		this.size = serverIpList.size();
		this.lastServerIndex = 0;
		for (int i = 0; i < size; i++) {
			serverToIndexMap.put(serverIpList.get(i), i);
		}

	}

	public String getServerIp(LoadBalancingAlgo algo) {
		// TODO Auto-generated method stub
		final int index = algo.findNextServer(size, lastServerIndex);
		if (index > size - 1) {
			throw new RuntimeException("No server found");
		}
		System.out.println("Server Index chosen for consumer Service " + index);
		lastServerIndex = index;
		return serverIpList.get(index);
	}

	public void removeService(String serverIp) {
		final Integer index = serverToIndexMap.get(serverIp);
		if (index != null) {
			serverIpList.remove(index.intValue());
		}

	}

}
