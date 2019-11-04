package org.googlielmo.binaryclassifier;

import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.io.ClassPathResource;

public class BinaryClassifier {
	
	public static void main(String[] args) throws Exception {
		// Load the model
		String simpleMlpJson = 
			new ClassPathResource("keras-binary-classifier.json").getFile().getPath();
		String simpleMlp = 
			new ClassPathResource("keras-binary-classifier.h5").getFile().getPath();
		
		MultiLayerNetwork model = KerasModelImport.
                    importKerasSequentialModelAndWeights(simpleMlpJson, simpleMlp, false);
					
		// Create a random sample
		int inputs = 10;
		INDArray features = Nd4j.zeros(1, inputs);
		for (int i=0; i<inputs; i++) 
		features.putScalar(0, Long.valueOf(i), Math.random() < 0.5 ? 0 : 1);
		System.out.println("features rank is " + features.rank());
		
		// Make a prediction
		double prediction = model.output(features).getDouble(0);
		prediction = prediction < 0.5 ? 0 : 1;
		System.out.println("The output label value is " + prediction);
	}
}
