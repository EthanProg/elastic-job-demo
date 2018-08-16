package com.test.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dangdang.ddframe.job.lite.lifecycle.domain.JobSettings;
import com.test.service.ElasticJobApiService;
import com.test.web.util.ResponseUtil;
import com.test.web.util.ResultEnum;

/**
 * 作业配置的controller.
 *
 * @author liuxiaoliang
 */
@RestController
public class JobConfigController {

	private static Logger log = LoggerFactory.getLogger(JobConfigController.class);

	@Autowired
	private ElasticJobApiService elasticJobApiService;

	/**
	 * 获取作业配置.
	 * 
	 * @param jobName
	 *            作业名称
	 * @return 作业配置
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/jobs/config/get/{jobName}", produces = "application/json;charset=utf-8")
	public String getJobSettings(@PathVariable("jobName") String jobName) {
		try {
			return ResponseUtil.returnSuccess(elasticJobApiService.getJobSettingsAPI().getJobSettings(jobName));
		} catch (Exception e) {
			log.error("获取作业配置异常, jobName={}", jobName, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 修改作业配置.
	 * 
	 * @param jobSettings
	 *            作业配置
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/jobs/config/updateJobSettings", produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	public String updateJobSettings(@RequestBody JobSettings jobSettings) {
		try {
			elasticJobApiService.getJobSettingsAPI().updateJobSettings(jobSettings);
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("作业维度触发作业异常, jobSettings={}", jobSettings, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}

	/**
	 * 删除作业配置.
	 * 
	 * @param jobName
	 *            作业名称
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/jobs/config/delete/{jobName}", produces = "application/json;charset=utf-8")
	public String removeJob(@PathVariable("jobName") String jobName) {
		try {
			elasticJobApiService.getJobSettingsAPI().removeJobSettings(jobName);
			return ResponseUtil.returnSuccess(null);
		} catch (Exception e) {
			log.error("获取作业配置异常, jobName={}", jobName, e);
			return ResponseUtil.returnResult(ResultEnum.FAIL_EXCEPTION);
		}
	}
}
