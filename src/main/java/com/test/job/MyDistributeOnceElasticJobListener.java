package com.test.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.AbstractDistributeOnceElasticJobListener;

public class MyDistributeOnceElasticJobListener extends AbstractDistributeOnceElasticJobListener {

	private static Logger log = LoggerFactory.getLogger(MyDistributeOnceElasticJobListener.class);

	public MyDistributeOnceElasticJobListener(long startedTimeoutMilliseconds, long completedTimeoutMilliseconds) {
		super(startedTimeoutMilliseconds, completedTimeoutMilliseconds);
	}

	@Override
	public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {
		log.info("分布式监听器开始...");
	}

	@Override
	public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
		log.info("分布式监听器结束...");
	}

}
