package com.diligentgroup.sfgthvpetclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.diligentgroup.sfgthvpetclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
	
	protected Map<Long, T> map = new HashMap<Long, T>();
	
	Set<T> findAll() {
		return new HashSet<T>(map.values());
	}

	T findById(ID id) {
		return map.get(id);
	}
	
	T save(T object) {
		if (object != null) {
			if (object.getId() == null) {
				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		} else {
			throw new RuntimeException("Object can not be null!");
		}
		return object;
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	private Long getNextId() {
		Long nextId = 1L;
		if (!map.isEmpty()) {
			nextId = Collections.max(map.keySet()) + 1;
		}
		return nextId;
	}
}
