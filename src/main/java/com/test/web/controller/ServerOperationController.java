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
 * 服务器维度操作的controller.
 *
 * @author liuxiaoliang
 */
@RestController
public class ServerOperationController {

	private static Logger log = LoggerFactory.getLogger(ServerOperationController.class);

	@Autowired
	private ElasticJobApiService elasticJobService;

	/**
	 * 获取服务器总数.
	 * 
	 * @return 服务器总数
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/servers/count", produces = "application/json;charset=utf-8")
	public String getServersTotalCount() {
		try {
			return ResponseUtil.returnSuccess(elasticJobService.getServerStatisticsAPI().getServersTotalCount());
		} catch (Exception e) {
			log.error("服务器维度获取服务器总数异常", e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 获取服务器详情.
	 * 
	 * @return 服务器详情集合
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/servers/getAllServersBriefInfo", produces = "application/json;charset=utf-8")
	public String getAllServersBriefInfo() {
		try {
			return ResponseUtil.returnSuccess(elasticJobService.getServerStatisticsAPI().getAllServersBriefInfo());
		} catch (Exception e) {
			log.error("服务器维度获取服务器详情异常", e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 禁用作业.
	 *
	 * @param serverIp
	 *            服务器IP地址
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/servers/{serverIp}/disable", produces = "application/json;charset=utf-8")
	public String disableServer(@PathVariable("serverIp") String serverIp) {
		try {
			elasticJobService.getJobOperatorAPI().disable(Optional.<String>absent(), Optional.of(serverIp));
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("服务器维度禁用作业异常, serverIp={}", serverIp, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 启用作业.
	 *
	 * @param serverIp
	 *            服务器IP地址
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/servers/{serverIp}/enable", produces = "application/json;charset=utf-8")
	public String enableServer(@PathVariable("serverIp") String serverIp) {
		try {
			elasticJobService.getJobOperatorAPI().enable(Optional.<String>absent(), Optional.of(serverIp));
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("服务器维度启用作业异常, serverIp={}", serverIp, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 终止作业.
	 *
	 * @param serverIp
	 *            服务器IP地址
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/servers/{serverIp}/shutdown", produces = "application/json;charset=utf-8")
	public String shutdownServer(@PathVariable("serverIp") String serverIp) {
		try {
			elasticJobService.getJobOperatorAPI().shutdown(Optional.<String>absent(), Optional.of(serverIp));
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("服务器维度终止作业异常, serverIp={}", serverIp, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 清理作业.
	 *
	 * @param serverIp
	 *            服务器IP地址
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/servers/{serverIp}/remove", produces = "application/json;charset=utf-8")
	public String removeServer(@PathVariable("serverIp") String serverIp) {
		try {
			elasticJobService.getJobOperatorAPI().remove(Optional.<String>absent(), Optional.of(serverIp));
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("服务器维度清理作业异常, serverIp={}", serverIp, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 获取该服务器上注册的作业的简明信息.
	 *
	 * @param serverIp
	 *            服务器IP地址
	 * @return 作业简明信息对象集合
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/servers/{serverIp}/jobs", produces = "application/json;charset=utf-8")
	public String getJobs(@PathVariable("serverIp") String serverIp) {
		try {
			return ResponseUtil.returnSuccess(elasticJobService.getJobStatisticsAPI().getJobsBriefInfo(serverIp));
		} catch (Exception e) {
			log.error("服务器维度获取服务器作业简明信息异常, serverIp={}", serverIp, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 禁用作业.
	 * 
	 * @param serverIp
	 *            服务器IP地址
	 * @param jobName
	 *            作业名称
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/servers/{serverIp}/jobs/{jobName}/disable", produces = "application/json;charset=utf-8")
	public String disableServerJob(@PathVariable("serverIp") String serverIp, @PathVariable("jobName") String jobName) {
		try {
			elasticJobService.getJobOperatorAPI().disable(Optional.of(jobName), Optional.of(serverIp));
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("服务器维度禁用作业异常, serverIp={}, jobName={}", serverIp, jobName, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 启用作业.
	 *
	 * @param serverIp
	 *            服务器IP地址
	 * @param jobName
	 *            作业名称
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/servers/{serverIp}/jobs/{jobName}/enable", produces = "application/json;charset=utf-8")
	public String enableServerJob(@PathVariable("serverIp") String serverIp, @PathVariable("jobName") String jobName) {
		try {
			elasticJobService.getJobOperatorAPI().enable(Optional.of(jobName), Optional.of(serverIp));
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("服务器维度启用作业异常, serverIp={}, jobName={}", serverIp, jobName, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 终止作业.
	 *
	 * @param serverIp
	 *            服务器IP地址
	 * @param jobName
	 *            作业名称
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/servers/{serverIp}/jobs/{jobName}/shutdown", produces = "application/json;charset=utf-8")
	public String shutdownServerJob(@PathVariable("serverIp") String serverIp, @PathVariable("jobName") String jobName) {
		try {
			elasticJobService.getJobOperatorAPI().shutdown(Optional.of(jobName), Optional.of(serverIp));
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("服务器维度终止作业异常, serverIp={}, jobName={}", serverIp, jobName, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 清理作业.
	 *
	 * @param serverIp
	 *            服务器IP地址
	 * @param jobName
	 *            作业名称
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/servers/{serverIp}/jobs/{jobName}/remove", produces = "application/json;charset=utf-8")
	public String removeServerJob(@PathVariable("serverIp") String serverIp, @PathVariable("jobName") String jobName) {
		try {
			elasticJobService.getJobOperatorAPI().remove(Optional.of(jobName), Optional.of(serverIp));
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("服务器维度清理作业异常, serverIp={}, jobName={}", serverIp, jobName, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}
}
