package com.test.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dangdang.ddframe.job.lite.lifecycle.api.JobAPIFactory;
import com.dangdang.ddframe.job.lite.lifecycle.api.JobOperateAPI;
import com.dangdang.ddframe.job.lite.lifecycle.api.JobSettingsAPI;
import com.dangdang.ddframe.job.lite.lifecycle.api.JobStatisticsAPI;
import com.dangdang.ddframe.job.lite.lifecycle.api.ServerStatisticsAPI;
import com.dangdang.ddframe.job.lite.lifecycle.api.ShardingOperateAPI;
import com.dangdang.ddframe.job.lite.lifecycle.api.ShardingStatisticsAPI;
import com.google.common.base.Optional;

@Service
public class ElasticJobApiService {

	@Value("${elaticjob.zookeeper.server-lists}")
	private String zkUrl;

	@Value("${elaticjob.zookeeper.namespace}")
	private String namespace;

	@Value("${elaticjob.zookeeper.digest}")
	private String digest;

	private JobSettingsAPI jobSettingsAPI;

	private JobOperateAPI jobOperatorAPI;

	private ShardingOperateAPI shardingOperateAPI;

	private JobStatisticsAPI jobStatisticsAPI;

	private ServerStatisticsAPI serverStatisticsAPI;

	private ShardingStatisticsAPI shardingStatisticsAPI;

	@PostConstruct
	public void init() {
		jobSettingsAPI = JobAPIFactory.createJobSettingsAPI(zkUrl, namespace, Optional.fromNullable(digest));
		jobOperatorAPI = JobAPIFactory.createJobOperateAPI(zkUrl, namespace, Optional.fromNullable(digest));
		shardingOperateAPI = JobAPIFactory.createShardingOperateAPI(zkUrl, namespace, Optional.fromNullable(digest));
		jobStatisticsAPI = JobAPIFactory.createJobStatisticsAPI(zkUrl, namespace, Optional.fromNullable(digest));
		serverStatisticsAPI = JobAPIFactory.createServerStatisticsAPI(zkUrl, namespace, Optional.fromNullable(digest));
		shardingStatisticsAPI = JobAPIFactory.createShardingStatisticsAPI(zkUrl, namespace, Optional.fromNullable(digest));
	}

	public String getZkUrl() {
		return zkUrl;
	}

	public void setZkUrl(String zkUrl) {
		this.zkUrl = zkUrl;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public JobSettingsAPI getJobSettingsAPI() {
		return jobSettingsAPI;
	}

	public void setJobSettingsAPI(JobSettingsAPI jobSettingsAPI) {
		this.jobSettingsAPI = jobSettingsAPI;
	}

	public JobOperateAPI getJobOperatorAPI() {
		return jobOperatorAPI;
	}

	public void setJobOperatorAPI(JobOperateAPI jobOperatorAPI) {
		this.jobOperatorAPI = jobOperatorAPI;
	}

	public ShardingOperateAPI getShardingOperateAPI() {
		return shardingOperateAPI;
	}

	public void setShardingOperateAPI(ShardingOperateAPI shardingOperateAPI) {
		this.shardingOperateAPI = shardingOperateAPI;
	}

	public JobStatisticsAPI getJobStatisticsAPI() {
		return jobStatisticsAPI;
	}

	public void setJobStatisticsAPI(JobStatisticsAPI jobStatisticsAPI) {
		this.jobStatisticsAPI = jobStatisticsAPI;
	}

	public ServerStatisticsAPI getServerStatisticsAPI() {
		return serverStatisticsAPI;
	}

	public void setServerStatisticsAPI(ServerStatisticsAPI serverStatisticsAPI) {
		this.serverStatisticsAPI = serverStatisticsAPI;
	}

	public ShardingStatisticsAPI getShardingStatisticsAPI() {
		return shardingStatisticsAPI;
	}

	public void setShardingStatisticsAPI(ShardingStatisticsAPI shardingStatisticsAPI) {
		this.shardingStatisticsAPI = shardingStatisticsAPI;
	}

	@Override
	public String toString() {
		return "ElasticJobService [zkUrl=" + zkUrl + ", namespace=" + namespace + ", digest=" + digest + "]";
	}

}
