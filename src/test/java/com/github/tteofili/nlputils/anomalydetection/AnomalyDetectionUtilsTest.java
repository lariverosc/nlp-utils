package com.github.tteofili.nlputils.anomalydetection;

import org.junit.Test;

import com.github.tteofili.nlputils.TestUtils;
import com.github.tteofili.nlputils.TrainingExample;
import com.github.tteofili.nlputils.TrainingSet;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Testcase for {@link com.github.tteofili.nlputils.anomalydetection.AnomalyDetectionUtils}
 */
public class AnomalyDetectionUtilsTest {
  @Test
  public void testGaussianDistributionProbability() throws Exception {
    TrainingSet trainingSet = new TrainingSet();
    TestUtils.fillTrainingSet(trainingSet, 100, 5);
    double[] mus = AnomalyDetectionUtils.fitMus(trainingSet);
    assertNotNull(mus);
    double[] sigmas = AnomalyDetectionUtils.fitSigmas(mus, trainingSet);
    assertNotNull(sigmas);
    TrainingExample newInput = new TrainingExample(new double[]{1d, 2d, 1000d, 123d, 0.1d}, 0d);
    double probability = AnomalyDetectionUtils.getGaussianProbability(newInput, mus, sigmas);
    assertTrue("negative probability " + probability, 0 <= probability);
    assertTrue("probability bigger than 1 " + probability, 1 >= probability);
  }

  @Test
  public void testGaussianDistributionProbability2() throws Exception {
    TrainingSet trainingSet = new TrainingSet();
    TestUtils.fillTrainingSet(trainingSet, 100, 5);
    TrainingExample newInput = new TrainingExample(new double[]{1d, 2d, 1000d, 123d, 0.1d}, 0d);
    double probability = AnomalyDetectionUtils.getGaussianProbability(newInput, trainingSet);
    assertTrue("negative probability " + probability, 0 <= probability);
    assertTrue("probability bigger than 1 " + probability, 1 >= probability);
  }
}
