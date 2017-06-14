package com.e_tec.e_tecserverI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.e_tec.e_tecserverI.database.DataBaseClass;
import com.e_tec.e_tecserverI.model.DistributionCenter;
import com.e_tec.e_tecserverI.xml.writer.XMLWriterDistributionCenter;

public class DistributionCenterService {
	
private Map<String, DistributionCenter> distributionList = DataBaseClass.getDistributionList();
	
	public DistributionCenterService() {
//		distributionList.put("San Pedro", new DistributionCenter("San Pedro", "VideoJuegos", 13, 14));
//		distributionList.put("Multiplaza", new DistributionCenter("Multiplaza", "VideoJuegos", 13, 15));
//		distributionList.put("Paseo Metropoli", new DistributionCenter("Paseo Metropoli", "VideoJuegos", 13, 16));
				
	}
	
	public List<DistributionCenter> getAllDistributionCenter() {
		return new ArrayList<DistributionCenter>(distributionList.values());
	}
	
	public DistributionCenter getDistributionCenter(String key) {
		return distributionList.get(key);
	}

	public DistributionCenter addClient(DistributionCenter distribution) {
		distributionList.put(distribution.getName(), distribution);
		XMLWriterDistributionCenter.writeXML(new ArrayList<DistributionCenter>(distributionList.values()));
		return distribution;
	}

	public DistributionCenter updateClient(DistributionCenter distribution) {
		if (distribution.getName().isEmpty()) {
			return null;
		}

		distributionList.put(distribution.getName(), distribution);
		XMLWriterDistributionCenter.writeXML(new ArrayList<DistributionCenter>(distributionList.values()));
		return distribution;
	}

	public void deleteDistributionCenter(String key) {
		distributionList.remove(key);
		XMLWriterDistributionCenter.writeXML(new ArrayList<DistributionCenter>(distributionList.values()));
	}
}
