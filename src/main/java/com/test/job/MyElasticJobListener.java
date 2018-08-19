package com.test.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;

public class MyElasticJobListener implements ElasticJobListener {
	
	private static Logger log = LoggerFactory.getLogger(MyElasticJobListener.class);

	@Override
	public void beforeJobExecuted(ShardingContexts shardingContexts) {
		log.info("作业执行前");
	}

	@Override
	public void afterJobExecuted(ShardingContexts shardingContexts) {
		log.info("作业执行后");
	}

}
