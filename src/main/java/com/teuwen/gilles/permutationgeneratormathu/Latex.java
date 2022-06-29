/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teuwen.gilles.permutationgeneratormathu;

/**
 *
 * @author Gilles Teuwen u21465772
 */
public class Latex {

	public static class Syntax {

		public static String fraction(String num, String den) {
			String out = String.format("\\frac{%s}{%s}", num, den);
			return out;
		}

		public static String sqrt(String arg) {
			String out = String.format("\\sqrt{%s}", arg);
			return out;
		}

		public static String subscript(String main, String sub) {
			String out = String.format("%s_{%s}", main, sub);
			return out;
		}

		public static String text(String text) {
			String out = String.format("\\text{%s}", text);
			return out;
		}

		public static String ell() {
			String out = "\\ell";
			return out;
		}
	}

	public static class PropertiesOfOperations {

		/*
		generating a series of permutations 
		 */
		public static String generateWaterSequenceSection(int numberOfPermutations) {
			String out = "";
			for (int i = 0; i < numberOfPermutations; i++) {
				//out += String.format("\\item Permutation %s \\\\ \n", (i + 1) + "");
				out += Latex.PropertiesOfOperations.generateWaterPermutation();
				out += "\n\n";
			}
			return out;
		}

		public static String generateBoxesSection(int numberOfPermutations) {
			String out = "";
			for (int i = 0; i < numberOfPermutations; i++) {
				//out += String.format("\\item Permutation %s \\\\ \n", (i + 1) + "");
				out += Latex.PropertiesOfOperations.generateBoxesPermutation();
				out += "\n\n";
			}
			return out;
		}

		public static String generateLearnersSection(int numberOfPermutations) {
			String out = "";
			for (int i = 0; i < numberOfPermutations; i++) {
				//out += String.format("\\item Permutation %s \\\\ \n", (i + 1) + "");
				out += Latex.PropertiesOfOperations.generateLearnersPermutation();
				out += "\n\n";
			}
			return out;
		}

		public static String generateOrangesSection(int numberOfPermutations) {
			String out = "";
			for (int i = 0; i < numberOfPermutations; i++) {
				//out += String.format("\\item Permutation %s \\\\ \n", (i + 1) + "");
				out += Latex.PropertiesOfOperations.generateOrangesPermutation();
				out += "\n\n";
			}
			return out;
		}

		/*
		Generating full permutations (questions with correct and incorrect answers)
		 */
		public static String generateWaterPermutation() {
			int min = 10000;
			int max = 50000;

			int firstTank = (int) ((Math.random() * (max - min + 1)) + min);
			System.out.println(firstTank);
			int secondTank = (int) ((Math.random() * (max - min + 1)) + min);

			String out = generateWaterQuestion(firstTank, secondTank);
			out += Syntax.text("Correct: ") + generateAdditonCorrectAnswer(firstTank, secondTank) + "\\\\ \n";
			for (int i = 0; i < 3; i++) {
				out += Syntax.text("Incorrect: ") + generateAdditionIncorrectAnsewer(firstTank, secondTank, i + 1) + "\\\\ \n";
			}
			out += Syntax.text("Incorrect: ") + Syntax.text("None of the above") + "\\\\ \n";
			return out;
		}

		public static String generateSoccerPermutation() {
			int min = 1000;
			int max = 5000;

			int northStand = (int) ((Math.random() * (max - min + 1)) + min);
			int southStand = (int) ((Math.random() * (max - min + 1)) + min);

			String out = generateSoccerQuestion(northStand, southStand);
			out += Syntax.text("Correct: ") + generateAdditonCorrectAnswer(northStand, southStand) + "\\\\ \n";
			for (int i = 0; i < 3; i++) {
				out += Syntax.text("Incorrect: ") + generateAdditionIncorrectAnsewer(northStand, southStand, i + 1) + "\\\\ \n";
			}
			out += Syntax.text("Incorrect: ") + Syntax.text("None of the above") + "\\\\ \n";
			return out;
		}

		public static String generateBoxesPermutation() {
			int min = 2;
			int max = 9;

			int s1 = (int) ((Math.random() * (max - min + 1)) + min);
			int s2 = (int) ((Math.random() * (max - min + 1)) + min);
			int s3 = (int) ((Math.random() * (max - min + 1)) + min);
			int s4 = (int) ((Math.random() * (max - min + 1)) + min);

			String out = generateBoxesQuestion(s1, s2, s3, s4);
			out += Syntax.text("Correct: ") + generateAdditonCorrectAnswer(s1, s2, s3, s4) + "\\\\ \n";
			for (int i = 0; i < 3; i++) {
				out += Syntax.text("Incorrect: ") + generateAdditionIncorrectAnsewer(s1, s2, s3, s4, i + 1) + "\\\\ \n";
			}
			out += Syntax.text("Incorrect: ") + Syntax.text("None of the above") + "\\\\ \n";
			return out;
		}

		public static String generateLearnersPermutation() {
			int minTtl = 1000;
			int maxTtl = 2500;

			int total = (int) ((Math.random() * (maxTtl - minTtl + 1)) + minTtl);

			int minGirls = (int) (total * 0.3);
			int maxGirls = (int) (total * 0.7);

			int girls = (int) ((Math.random() * (maxGirls - minGirls + 1)) + minGirls);

			String out = generateLearnersQuestion(total, girls);
			out += Syntax.text("Correct: ") + generateSubtractionCorrectAnswer(total, girls) + "\\\\ \n";
			for (int i = 0; i < 3; i++) {
				out += Syntax.text("Incorrect: ") + generateSubtractionIncorrectAnswer(total, girls, i + 1) + "\\\\ \n";
			}
			out += Syntax.text("Incorrect: ") + Syntax.text("None of the above") + "\\\\ \n";
			return out;
		}

		public static String generateOrangesPermutation() {
			int min = 3;
			int max = 20;

			int o1 = (int) ((Math.random() * (max - min + 1)) + min);
			int o2 = (int) ((Math.random() * (max - min + 1)) + min);
			int o3 = (int) ((Math.random() * (max - min + 1)) + min);

			String out = generateOrangesQuestion(o1, o2, o3);
			out += Syntax.text("Correct: ") + generateAdditonCorrectAnswer(o1, o2, o3) + "\\\\ \n";
			for (int i = 0; i < 3; i++) {
				out += Syntax.text("Incorrect: ") + generateAdditionIncorrectAnsewer(o1, o2, o3, i + 1) + "\\\\ \n";
			}
			out += Syntax.text("Incorrect: ") + Syntax.text("None of the above") + "\\\\ \n";
			return out;
		}

		public static String generatePaperPermutation() {
			int min = 3;
			int max = 20;

			int o1 = (int) ((Math.random() * (max - min + 1)) + min);
			int o2 = (int) ((Math.random() * (max - min + 1)) + min);
			int o3 = (int) ((Math.random() * (max - min + 1)) + min);

			String out = generateOrangesQuestion(o1, o2, o3);
			out += Syntax.text("Correct: ") + generateAdditonCorrectAnswer(o1, o2, o3) + "\\\\ \n";
			for (int i = 0; i < 3; i++) {
				out += Syntax.text("Incorrect: ") + generateAdditionIncorrectAnsewer(o1, o2, o3, i + 1) + "\\\\ \n";
			}
			out += Syntax.text("Incorrect: ") + Syntax.text("None of the above") + "\\\\ \n";
			return out;
		}
		/*
		Generating questions
		 */
		public static String generateWaterQuestion(int firstTank, int secondTank) {

			String out = Syntax.text(String.format("There are two water tanks. The first tank has %d ", firstTank)) + Syntax.ell()
				+ Syntax.text(String.format(" and the second has %d ", secondTank)) + Syntax.ell() + Syntax.text(".") + "\\\\"
				+ Syntax.text("How many litres of water do both tanks hold together?") + "\\\\ \n";

			System.out.println(out);
			return out;
		}

		public static String generateSoccerQuestion(int northStand, int southStand) {

			String out = Syntax.text(String.format("At a soccer game there were %s people sitting in the North stand and %s people sitting in the South stand. "
				+ "How many people altogether were at the soccer game?", northStand, southStand)) + "\\\\ \n";
			return out;
		}

		public static String generateBoxesQuestion(int stop1, int stop2, int stop3, int stop4) {

			String out = (String.format(Syntax.text("A delivery driver had to make four stops on his route. ") + "\\\\ \n"
				+ Syntax.text("At the first stop he dropped off %d boxes. ") + "\\\\ \n"
				+ Syntax.text("At the second stop he dropped off %d boxes. ") + "\\\\ \n"
				+ Syntax.text("At the third stop he dropped off %d boxes. ") + "\\\\ \n"
				+ Syntax.text("At the fourth stop he dropped off %d boxes. ") + "\\\\ \n"
				+ Syntax.text("How many boxes were in his truck when he started?") + "\\\\ \n", stop1, stop2, stop3, stop4)) + "\\\\ \n";
			return out;
		}

		public static String generateLearnersQuestion(int total, int girls) {

			String out = (String.format(Syntax.text("There are %d learners in a school. ") + "\\\\ \n"
				+ Syntax.text("If %d of them are girls, how many are boys? ") + "\\\\ \n", total, girls)) + "\\\\ \n";
			return out;
		}

		public static String generateOrangesQuestion(int oranges1, int oranges2, int oranges3) {

			String out = (String.format(Syntax.text("Wendy had %d oranges, her sister had %d oranges and her brother had %d oranges. ") + "\\\\ \n"
				+ Syntax.text("How many oranges did they have in total? ") + "\\\\ \n",
				oranges1, oranges2, oranges3)) + "\\\\ \n";
			return out;
		}

		public static String generatePaperQuestion(int total, int paper1, int paper2, int paper3, int paper4) {

			String out = (String.format(Syntax.text("Olivia had %d pieces of paper in her folder. ") + "\\\\ \n"
				+ Syntax.text("She used %d pieces on Monday, %d pieces on Tuesday, %d  pieces on Wednesdat and %d on Friday. ") + "\\\\ \n"
				+ Syntax.text("How many pieces does she have left. ") + "\\\\ \n",
				total, paper1, paper2, paper3, paper4)) + "\\\\ \n";
			return out;
		}

		/*
		Generating correct addition answers
		 */
		public static int generateAdditonCorrectAnswer(int number1, int number2) {
			return number1 + number2;
		}

		public static int generateAdditonCorrectAnswer(int number1, int number2, int number3) {
			return number1 + number2 + number3;
		}

		public static int generateAdditonCorrectAnswer(int number1, int number2, int number3, int number4) {
			return number1 + number2 + number3 + number4;
		}

		/*
		Generating incorrect addition answers
		 */
		public static int generateAdditionIncorrectAnsewer(int number1, int number2, int typeOfIncorrect) {
			//TypesOfIncorrect
			//1:Minus instead of add
			//2:Swapped digits
			//3:Off by a small margin
			int min = 1;
			int max = 5;
			int offBy = 1;
			switch (typeOfIncorrect) {
				case 1:
					int minused = number1 - number2;
					if (minused < 0) {
						return number2 - number1;
					}
					return minused;
				case 2:

					String ans = (number1 + number2) + "";
					StringBuilder wrongAns = new StringBuilder(ans);
					for (int i = 1; i < ans.length() - 1; i++) {
						for (int j = 2; j < ans.length(); j++) {
							if (ans.charAt(i) != ans.charAt(j)) {
								char tmp = ans.charAt(i);
								wrongAns.setCharAt(i, wrongAns.charAt(j));
								wrongAns.setCharAt(j, tmp);
								return Integer.parseInt(wrongAns.toString());
							}

						}
					}

					break;
				case 3:

					int choice = (int) ((Math.random() * (2)));
					System.out.println(choice);
					if (choice == 0) {
						offBy = (int) ((Math.random() * (max - min + 1)) + min);
						return number1 + number2 + offBy;
					} else {
						offBy = (int) ((Math.random() * (max - min + 1)) + min);
						return number1 + number2 - offBy;
					}

				default:
					System.out.println("Invalid number");
					break;
			}
			System.out.println("Mistake (probably with digit swap)");
			return -1;
		}

		public static int generateAdditionIncorrectAnsewer(int number1, int number2, int number3, int typeOfIncorrect) {
			//TypesOfIncorrect
			//1:Minus instead of add
			//2:Swapped digits
			//3:Off by a small margin
			int min = 1;
			int max = 5;
			int offBy = 1;
			switch (typeOfIncorrect) {
				case 1:
					int minused = number1 - number2 + number3;
					if (minused < 0) {
						return number2 - number1 + number3;
					}
					return minused;
				case 2:

					String ans = (number1 + number2 + number3) + "";
					StringBuilder wrongAns = new StringBuilder(ans);
					for (int i = 0; i < ans.length() - 1; i++) {
						for (int j = 1; j < ans.length(); j++) {
							if (ans.charAt(i) != ans.charAt(j)) {
								char tmp = ans.charAt(i);
								wrongAns.setCharAt(i, wrongAns.charAt(j));
								wrongAns.setCharAt(j, tmp);
								return Integer.parseInt(wrongAns.toString());
							}

						}
					}

					break;
				case 3:

					int choice = (int) ((Math.random() * (2)));
					System.out.println(choice);
					if (choice == 0) {
						offBy = (int) ((Math.random() * (max - min + 1)) + min);
						return number1 + number2 + number3 + offBy;
					} else {
						offBy = (int) ((Math.random() * (max - min + 1)) + min);
						return number1 + number2 + number3 - offBy;
					}

				default:
					System.out.println("Invalid number");
					break;
			}
			System.out.println("Mistake (probably with digit swap)");
			return -1;
		}

		public static int generateAdditionIncorrectAnsewer(int number1, int number2, int number3, int number4, int typeOfIncorrect) {
			int min = 1;
			int max = 5;
			int offBy = 1;
			switch (typeOfIncorrect) {
				case 1:
					int minused = number1 - number2 + number3 + number4;
					if (minused < 0) {
						return number2 - number1 + number3 + number4;
					}
					return minused;
				case 2:

					String ans = generateAdditonCorrectAnswer(number1, number2, number3, number4) + "";
					StringBuilder wrongAns = new StringBuilder(ans);
					for (int i = 0; i < ans.length() - 1; i++) {
						for (int j = 1; j < ans.length(); j++) {
							if (ans.charAt(i) != ans.charAt(j)) {
								char tmp = ans.charAt(i);
								wrongAns.setCharAt(i, wrongAns.charAt(j));
								wrongAns.setCharAt(j, tmp);
								return Integer.parseInt(wrongAns.toString());
							}

						}
					}

					break;
				case 3:

					int choice = (int) ((Math.random() * (2)));
					System.out.println(choice);
					if (choice == 0) {
						offBy = (int) ((Math.random() * (max - min + 1)) + min);
						return number1 + number2 + number3 + number4 + offBy;
					} else {
						offBy = (int) ((Math.random() * (max - min + 1)) + min);
						return number1 + number2 + number3 + number4 - offBy;
					}

				default:
					System.out.println("Invalid number");
					break;
			}
			System.out.println("Mistake (probably with digit swap)");
			return -1;
		}

		/*
		Generating correct substraction answers
		 */
		public static int generateSubtractionCorrectAnswer(int number1, int number2) {
			return number1 - number2;
		}

		public static int generateSubtractionCorrectAnswer(int total, int number1, int number2, int number3, int number4) {
			return total - number1 - number2 - number3 - number4;
		}

		/*
		Generating incorrect substraction answers
		 */
		public static int generateSubtractionIncorrectAnswer(int number1, int number2, int typeOfIncorrect) {
			//TypesOfIncorrect
			//1:Add instead of minus
			//2:Swapped digits
			//3:Off by a small margin
			int min = 1;
			int max = 5;
			int offBy = 1;
			switch (typeOfIncorrect) {
				case 1:
					int summed = number1 + number2;
					return summed;
				case 2:

					String ans = generateSubtractionCorrectAnswer(number1, number2) + "";
					StringBuilder wrongAns = new StringBuilder(ans);
					for (int i = 0; i < ans.length() - 1; i++) {
						for (int j = 1; j < ans.length(); j++) {
							if (ans.charAt(i) != ans.charAt(j)) {
								char tmp = ans.charAt(i);
								wrongAns.setCharAt(i, wrongAns.charAt(j));
								wrongAns.setCharAt(j, tmp);
								return Integer.parseInt(wrongAns.toString());
							}

						}
					}

					break;
				case 3:

					int choice = (int) ((Math.random() * (2)));
					System.out.println(choice);
					if (choice == 0) {
						offBy = (int) ((Math.random() * (max - min + 1)) + min);
						return number1 - number2 + offBy;
					} else {
						offBy = (int) ((Math.random() * (max - min + 1)) + min);
						return number1 - number2 - offBy;
					}

				default:
					System.out.println("Invalid number");
					break;
			}
			System.out.println("Mistake (probably with digit swap)");
			return -1;
		}

		public static int generateSubtractionIncorrectAnswer(int total, int number1, int number2, int number3, int number4, int typeOfIncorrect) {
			//TypesOfIncorrect
			//1:Add instead of minus
			//2:Swapped digits
			//3:Off by a small margin
			int min = 1;
			int max = 5;
			int offBy = 1;
			switch (typeOfIncorrect) {
				case 1:
					int summed = total - number1 - number2 - number3 + number4;
					return summed;
				case 2:

					String ans = generateSubtractionCorrectAnswer(total, number1, number2, number3, number4) + "";
					StringBuilder wrongAns = new StringBuilder(ans);
					for (int i = 0; i < ans.length() - 1; i++) {
						for (int j = 1; j < ans.length(); j++) {
							if (ans.charAt(i) != ans.charAt(j)) {
								char tmp = ans.charAt(i);
								wrongAns.setCharAt(i, wrongAns.charAt(j));
								wrongAns.setCharAt(j, tmp);
								return Integer.parseInt(wrongAns.toString());
							}

						}
					}

					break;
				case 3:

					int choice = (int) ((Math.random() * (2)));
					System.out.println(choice);
					if (choice == 0) {
						offBy = (int) ((Math.random() * (max - min + 1)) + min);
						return generateSubtractionCorrectAnswer(total, number1, number2, number3, number4) + offBy;
					} else {
						offBy = (int) ((Math.random() * (max - min + 1)) + min);
						return generateSubtractionCorrectAnswer(total, number1, number2, number3, number4) - offBy;
					}

				default:
					System.out.println("Invalid number");
					break;
			}
			System.out.println("Mistake (probably with digit swap)");
			return -1;
		}

	}

	public static class Series {

		public static int calculateNthTerm(int first, int difference, int n) {
			return first + (difference * (n - 1));
		}

		public static String generateSequence(int first, int difference, int numTerms) {
			String out = "$ ";
			for (int i = 0; i < numTerms; i++) {
				out += (first + difference * i) + " ; ";
			}
			out += "\\dots$ \\\\ \n";
			return out;
		}

		public static String generateArithmeticSequenceQuestion(int first, int difference, int numTerms) {
			String out = "\\text{Given the sequence:}\\\\ \n";
			out += generateSequence(first, difference, numTerms);
			out += "\\text{Show that the above sequence is an arithmetic sequence.}\\\\ \n";
			return out;
		}

		public static String generateArithmeticSequenceAnwer(int first, int difference, int numTerms) {
			String out = "$ \\begin{aligned} \n";
			for (int i = 0; i < numTerms; i++) {
				out += (first + difference * i);
				if (i < numTerms - 1) {
					out += " ; ";
				} else {
					out += "\\\\ \n";
				}
			}

			for (int i = 1; i <= 2; i++) {
				int firstTerm = calculateNthTerm(first, difference, i);
				int secondTerm = calculateNthTerm(first, difference, i + 1);
				out += (Syntax.subscript("T", (i + 1) + "") + "-" + Syntax.subscript("T", (i + "")) + "&=" + secondTerm + "-" + firstTerm + "=" + (secondTerm - firstTerm) + "\\\\ \n");
			}

			out += "\\therefore T_{2}-T_{1}&=T_{3}-T_{2}\\\\ \n"
				+ "& \\therefore \\text { Arithmetic }\n"
				+ "\\end{aligned}\\\\$ \n";
			return out;
		}

		public static String generateArithmeticSequencePermutation(int first, int difference, int numTerms) {
			String out = generateArithmeticSequenceQuestion(first, difference, numTerms) + generateArithmeticSequenceAnwer(first, difference, numTerms);
			return out;
		}

		public static String generateAritmeticSequenceSection(int numberOfPermutations) {
			String out = "";
			for (int i = 0; i < numberOfPermutations; i++) {
				out += String.format("\\item Permutation %s \\\\ \n", (i + 1) + "");

				int minStart = 1;
				int maxStart = 10;

				int minDiff = 2;
				int maxDiff = 9;

				int start = (int) ((Math.random() * (maxStart - minStart + 1)) + minStart);
				int diff = (int) ((Math.random() * (maxDiff - minDiff + 1)) + minDiff);

				out += Latex.Series.generateArithmeticSequencePermutation(start, diff, 4);
				out += "\n\n";
			}
			return out;
		}
	}
}
