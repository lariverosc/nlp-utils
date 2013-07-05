package com.github.tteofili.nlputils.regression;

/**
 * Simplest {@link Hypothesis} which just linear combines inputs with weights
 */
public class LinearCombinationHypothesis implements Hypothesis {
  private double[] weights;

  @Override
  public double calculateOutput(double[] inputs) {
    double output = 0d;
    for (int i = 0; i < weights.length; i++) {
      output += weights[i] * inputs[i];
    }
    return output;
  }

  @Override
  public void updateParameters(double[] parameters) {
    weights = parameters;
  }
}
