package com.github.agourlay.cornichon.core

trait FeatureReport {
  val name: String
  val success: Boolean
}
case class SuccessFeatureReport(name: String, scenariosResult: Seq[SuccessScenarioReport]) extends FeatureReport {
  val success = true
}
case class FailedFeatureReport(name: String, scenarioReport: Seq[ScenarioReport], errors: Seq[String]) extends FeatureReport {
  val success = false
}

trait ScenarioReport {
  val scenarioName: String
  val success: Boolean
}
case class SuccessScenarioReport(scenarioName: String, successSteps: Seq[String]) extends ScenarioReport {
  val success = true
}
case class FailedScenarioReport(scenarioName: String, failedStep: FailedStep, successSteps: Seq[String], notExecutedStep: Seq[String]) extends ScenarioReport {
  val success = false
}

case class FailedStep(step: String, error: CornichonError)