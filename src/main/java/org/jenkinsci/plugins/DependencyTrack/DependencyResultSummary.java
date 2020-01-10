package org.jenkinsci.plugins.DependencyTrack;

import org.jenkinsci.plugins.DependencyTrack.model.Finding;
import org.jenkinsci.plugins.DependencyTrack.model.SeverityDistribution;
import org.jenkinsci.plugins.DependencyTrack.model.Thresholds;

import java.util.Collections;
import java.util.List;

public class DependencyResultSummary {

    private final SeverityDistribution severityDistribution;
    private final List<Finding> findings;

    public DependencyResultSummary(int buildNumber) {
        severityDistribution = new SeverityDistribution(buildNumber);
        findings = Collections.emptyList();
    }

    public DependencyResultSummary(ResultAction resultAction) {
        severityDistribution = resultAction.getSeverityDistribution();
        findings = resultAction.getFindings();
    }

    public SeverityDistribution getSeverityDistribution() {
        return severityDistribution;
    }

    public List<Finding> getFindings() {
        return findings;
    }
}
