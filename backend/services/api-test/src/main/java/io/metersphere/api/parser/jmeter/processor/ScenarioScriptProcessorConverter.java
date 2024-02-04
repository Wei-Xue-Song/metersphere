package io.metersphere.api.parser.jmeter.processor;

import io.metersphere.plugin.api.dto.ParameterConfig;
import io.metersphere.project.api.processor.ScriptProcessor;
import io.metersphere.project.dto.environment.processors.EnvScenarioScriptProcessor;
import org.apache.jmeter.protocol.java.sampler.BeanShellSampler;
import org.apache.jmeter.protocol.java.sampler.JSR223Sampler;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jorphan.collections.HashTree;

/**
 * 环境场景级前置处理器处理
 *
 * @Author: jianxing
 * @CreateTime: 2023-12-26  14:49
 */
public class ScenarioScriptProcessorConverter extends ScriptProcessorConverter {
    @Override
    public void parse(HashTree hashTree, ScriptProcessor scriptProcessor, ParameterConfig config) {
        if (!needParse(scriptProcessor, config) || !scriptProcessor.isValid()) {
            return;
        }
        EnvScenarioScriptProcessor scenarioScriptProcessor = (EnvScenarioScriptProcessor) scriptProcessor;
        Boolean associateScenarioResult = scenarioScriptProcessor.getAssociateScenarioResult();

        TestElement processor;
        if (isJSR233(scriptProcessor)) {
            processor = new JSR223Sampler();
        } else {
            processor = new BeanShellSampler();
        }

        parse(processor, scriptProcessor);
        // 标记当前处理器是否关联场景结果
        processor.setName("ASSOCIATE_RESULT_PROCESSOR_" + associateScenarioResult);
        hashTree.add(processor);
    }
}
