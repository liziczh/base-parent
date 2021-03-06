package com.liziczh.base.mvc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.base.common.condition.BaseCondition;
import com.liziczh.base.common.response.Response;
import com.liziczh.base.common.service.BaseMgmService;

@RestController
public abstract class BaseMgmController<T, K, C extends BaseCondition> {
	public abstract String getIndex() throws Exception;
	public abstract BaseMgmService<T, K, C> getService() throws Exception;
	@RequestMapping(value = "select", method = RequestMethod.GET)
	public Response<List<T>> select(@RequestBody C condition) throws Exception {
		List<T> list= getService().selectByCondition(condition);
		return new Response<List<T>>().complete(list);
	}
	@RequestMapping(value = "index", method = RequestMethod.POST)
	public String index() throws Exception {
		return getIndex();
	}
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Response<String> add(T entity) throws Exception {
		getService().addItem(entity);
		return new Response<String>().complete("操作成功");
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Response<String> update(T entity) throws Exception {
		getService().updateItem(entity);
		return new Response<String>().complete("操作成功");
	}
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public Response<T> getById(@PathVariable K id) throws Exception {
		T entity = getService().get(id);
		return new Response<T>().complete(entity);
	}
	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public Response<String> delete(@PathVariable K id) throws Exception {
		getService().delete(id);
		return new Response<String>().complete("操作成功");
	}
}
