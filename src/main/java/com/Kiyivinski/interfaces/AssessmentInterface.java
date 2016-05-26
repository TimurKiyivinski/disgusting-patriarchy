package com.Kiyivinski.interfaces;

import com.Kiyivinski.models.Assessment;

/**
 * The interface Assessment interface.
 */
public interface AssessmentInterface {
    /**
     * Gets assessment id.
     *
     * @return the assessment id
     */
    public String getAssessmentID();

    /**
     * Gets assessment.
     *
     * @return the assessment
     */
    public Assessment getAssessment();
}
