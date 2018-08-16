package com.test.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Optional;
import com.test.service.ElasticJobApiService;
import com.test.web.util.ResponseUtil;
import com.test.web.util.ResultEnum;

/**
 * 作业维度操作的controller.
 *
 * @author liuxiaoliang
 */
@RestController
public class JobOperationController {

	private static Logger log = LoggerFactory.getLogger(JobOperationController.class);

	@Autowired
	private ElasticJobApiService elasticJobApiService;

	/**
	 * 获取作业总数.
	 * 
	 * @return 作业总数
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/jobs/count", produces = "application/json;charset=utf-8")
	public String getJobsTotalCount() {
		try {
			return ResponseUtil.returnSuccess(elasticJobApiService.getJobStatisticsAPI().getJobsTotalCount());
		} catch (Exception e) {
			log.error("作业维度获取作业总数异常", e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 获取作业详情.
	 * 
	 * @return 作业详情集合
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/jobs/getAllJobsBriefInfo", produces = "application/json;charset=utf-8")
	public String getAllJobsBriefInfo() {
		try {
			return ResponseUtil.returnSuccess(elasticJobApiService.getJobStatisticsAPI().getAllJobsBriefInfo());
		} catch (Exception e) {
			log.error("作业维度获取作业详情异常", e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 触发作业.
	 * 
	 * @param jobName
	 *            作业名称
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/jobs/{jobName}/trigger", produces = "application/json;charset=utf-8")
	public String triggerJob(@PathVariable("jobName") String jobName) {
		try {
			elasticJobApiService.getJobOperatorAPI().trigger(Optional.of(jobName), Optional.<String>absent());
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("作业维度触发作业异常, jobName={}", jobName, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 禁用作业.
	 * 
	 * @param jobName
	 *            作业名称
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/jobs/{jobName}/disable", produces = "application/json;charset=utf-8")
	public String disableJob(@PathVariable("jobName") String jobName) {
		try {
			elasticJobApiService.getJobOperatorAPI().disable(Optional.of(jobName), Optional.<String>absent());
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("作业维度禁用作业异常, jobName={}", jobName, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 启用作业.
	 *
	 * @param jobName
	 *            作业名称
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/jobs/{jobName}/enable", produces = "application/json;charset=utf-8")
	public String enableJob(@PathVariable("jobName") String jobName) {
		try {
			elasticJobApiService.getJobOperatorAPI().enable(Optional.of(jobName), Optional.<String>absent());
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("作业维度启用作业异常, jobName={}", jobName, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 终止作业.
	 * 
	 * @param jobName
	 *            作业名称
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/jobs/{jobName}/shutdown", produces = "application/json;charset=utf-8")
	public String shutdownJob(@PathVariable("jobName") String jobName) {
		try {
			elasticJobApiService.getJobOperatorAPI().shutdown(Optional.of(jobName), Optional.<String>absent());
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("作业维度终止作业异常, jobName={}", jobName, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 获取分片信息.
	 * 
	 * @param jobName
	 *            作业名称
	 * @return 分片信息集合
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/jobs/{jobName}/sharding", produces = "application/json;charset=utf-8")
	public String getShardingInfo(@PathVariable("jobName") String jobName) {
		try {
			return ResponseUtil.returnSuccess(elasticJobApiService.getShardingStatisticsAPI().getShardingInfo(jobName));
		} catch (Exception e) {
			log.error("作业维度获取分片信息异常, jobName={}", jobName, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 禁用分片.
	 * 
	 * @param jobName
	 *            作业名称
	 * @param item
	 *            分片项
	 * @return 是否操作成功
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/jobs/{jobName}/sharding/{item}/disable", produces = "application/json;charset=utf-8")
	public String disableSharding(@PathVariable("jobName") String jobName, @PathVariable("item") String item) {
		try {
			elasticJobApiService.getShardingOperateAPI().disable(jobName, item);
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("作业维度禁用分片异常, jobName={}, item={}", jobName, item, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 启用分片.
	 * 
	 * @param jobName
	 *            作业名称
	 * @param item
	 *            分片项
	 * @return 是否操作成功
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/jobs/{jobName}/sharding/{item}/enable", produces = "application/json;charset=utf-8")
	public String enableSharding(@PathVariable("jobName") String jobName, @PathVariable("item") String item) {
		try {
			elasticJobApiService.getShardingOperateAPI().enable(jobName, item);
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("作业维度启用分片异常, jobName={}, item={}", jobName, item, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}
}
