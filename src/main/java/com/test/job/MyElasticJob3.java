package com.test.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

public class MyElasticJob3 implements SimpleJob {

	private static Logger log = LoggerFactory.getLogger(MyElasticJob3.class);

	@Override
	public void execute(ShardingContext context) {
		switch (context.getShardingItem()) {
		case 0:
			log.info("jobName={}", context.getJobName());
			log.info("jobParameter={}", context.getJobParameter());
			log.info("shardingItem={}", context.getShardingItem());
			log.info("shardingTotalCount={}", context.getShardingTotalCount());
			log.info("taskId={}", context.getTaskId());
			log.info("------------------------------------------------");
			break;
		case 1:
			log.info("jobName={}", context.getJobName());
			log.info("jobParameter={}", context.getJobParameter());
			log.info("shardingItem={}", context.getShardingItem());
			log.info("shardingTotalCount={}", context.getShardingTotalCount());
			log.info("taskId={}", context.getTaskId());
			log.info("------------------------------------------------");
			break;
		case 2:
			log.info("jobName={}", context.getJobName());
			log.info("jobParameter={}", context.getJobParameter());
			log.info("shardingItem={}", context.getShardingItem());
			log.info("shardingTotalCount={}", context.getShardingTotalCount());
			log.info("taskId={}", context.getTaskId());
			log.info("------------------------------------------------");
			break;
		case 3:
			log.info("jobName={}", context.getJobName());
			log.info("jobParameter={}", context.getJobParameter());
			log.info("shardingItem={}", context.getShardingItem());
			log.info("shardingTotalCount={}", context.getShardingTotalCount());
			log.info("taskId={}", context.getTaskId());
			log.info("------------------------------------------------");
			break;
		case 4:
			log.info("jobName={}", context.getJobName());
			log.info("jobParameter={}", context.getJobParameter());
			log.info("shardingItem={}", context.getShardingItem());
			log.info("shardingTotalCount={}", context.getShardingTotalCount());
			log.info("taskId={}", context.getTaskId());
			log.info("------------------------------------------------");
			break;
		default:
			log.info("jobName={}", context.getJobName());
			log.info("jobParameter={}", context.getJobParameter());
			log.info("shardingItem={}", context.getShardingItem());
			log.info("shardingTotalCount={}", context.getShardingTotalCount());
			log.info("taskId={}", context.getTaskId());
			log.info("------------------------------------------------");
		}
	}
}
