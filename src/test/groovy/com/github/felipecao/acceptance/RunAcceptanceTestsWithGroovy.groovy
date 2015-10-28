package com.github.felipecao.acceptance

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.Ignore
import org.junit.runner.RunWith

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        format = ["pretty", "html:target/cucumber", "json:target/cucumber.json"],
        glue = ["com.github.felipecao.acceptance.steps"],
        features = "classpath:com/github/felipecao/acceptance/features/")
class RunAcceptanceTestsWithGroovy {

}
