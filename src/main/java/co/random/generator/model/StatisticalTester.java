package co.random.generator.model;

import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Created by DiazHerrera on 30/04/2017.
 */
public class StatisticalTester {

    private static final double DEFAULT_CONFIDENCE_INTERVAL = 0.95;
    private static final NormalDistribution STANDARD_NORMAL_DISTRIBUTION = new NormalDistribution(0 , 1);

    public static boolean averageTest(RandomNumberSet randomNumberSet){

        double media = randomNumberSet.media();
        double N = randomNumberSet.size();
        double Zo = ( (media - 0.5) * Math.sqrt(N) ) / Math.sqrt((float)1/12);
        double confidenceInterval = DEFAULT_CONFIDENCE_INTERVAL;
        double Zb = STANDARD_NORMAL_DISTRIBUTION.inverseCumulativeProbability(confidenceInterval + (1-confidenceInterval)/2);

        if(Math.abs(Zo) < Zb)
            return true;
        return false;
    }

}
