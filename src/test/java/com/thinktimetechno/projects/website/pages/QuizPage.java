package com.thinktimetechno.projects.website.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;

public class QuizPage {

	public void click_quiz_button() {
		WebUI.clickElement(By.xpath("//div[@class='left-take-quiz ']/a[contains(text(),'Take Quiz')]"));
	}

	public void verify_quizPageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("Hc Fa | Quiz - American Health Care Academy"));
	}

	public void verify_successquizPageDisplays() {

		WebElement successquiz = WebUI
				.waitForElementVisible(By.xpath("(//h2[contains(text(),'CONGRATULATIONS!')])[1]"));
		String successquiztext = successquiz.getText();

		Assert.assertEquals(successquiztext, "CONGRATULATIONS!");
	}

	public void question_and_answer() throws InterruptedException {

		List<WebElement> questions = WebUI.getWebElements(By.xpath("//h3[@class='questions']"));
		int i = 0;
		for (WebElement question : questions) {
			String questionText = question.getText().trim();
			String cleanText = questionText.split("\\) ")[1];
			String correctAnswer = getCorrectAnswer(cleanText);

			if (!correctAnswer.isEmpty()) {

				WebUI.clickElementWithJs(
						By.xpath("//input[@class='input-radio-answer' and following-sibling::label[contains(text(), '"
								+ correctAnswer + "')]]"));

				i++;
			}
			if (i % 4 == 0 && i < 20) {
//				Thread.sleep(2000);

				WebElement nextButton = WebUI.getWebElement(By.xpath("//input[@id='next_btn']"));

				if (nextButton.isDisplayed()) {
					WebUI.clickElementWithJs(By.xpath("//input[@id='next_btn']"));
//					Thread.sleep(2000);
				}
			}

		}

	}

	public void submitQuiz() throws InterruptedException {
		WebUI.clickElementWithJs(By.xpath("//input[@id='submit_btn']"));
//		Thread.sleep(10000);

	}

	public String getCorrectAnswer(String questionText) {

		switch (questionText) {
		case "What is Hands-Only CPR?":
			return "Both B and C";
		case "What should you check for before you respond to an emergency situation?":
			return "Your safety";
		case "What is the recommended rate for performing chest compressions for victims of all ages?":
			return "At least 100 to 120 compressions per minute";
		case "What is the correct hand placement when performing chest compressions on an adult?":
			return "Place one hand on top of the other, interlacing the fingers";
		case "When performing CPR on an adult, you should push the chest at least _____ inches deep.":
			return "2 inches, but no more than 2.4";
		case "What steps should you follow to open the airway?":
			return "Tilt the head back and lift the chin";
		case "During infant CPR, you should push down ______ inches deep at a rate of at least ______ compressions per minute.":
			return "1.5, 100 to 120";
		case "When giving chest compressions to an infant you should use _____.":
			return "2 fingers";
		case "Before pushing the \"shock\" button on an AED, you should _______.":
			return "All of the above";
		case "When helping a choking child, you should give ________.":
			return "Thrusts into the abdomen";
		case "Which of these is NOT a nervous system emergency?":
			return "Heart attack";
		case "A patient suffering from an _________ attack would carry an inhaler.":
			return "Asthma";
		case "For which medical emergency would one use an epinephrine drug or epi-pen?":
			return "Allergy emergency";
		case "What is an allergic reaction?":
			return "When something a person is allergic to enters the body";
		case "What step should you take if a person is having a seizure?":
			return "Remove nearby objects that may hurt the person";
		case "Which of the following are causes for choking emergencies?":
			return "Talking or laughing while eating";
		case "What should you do if someone is on fire?":
			return "Both A and B";
		case "The two major classifications of wounds are:":
			return "Open wounds and closed wounds";
		case "If you are stung by a wasp or a bee, and they leave behind a poison sac, you should NOT ______.":
			return "Squeeze the sac";
		case "If you experience a sprain or strain, what method should you follow?":
			return "Follow RICE: rest, immobilize, cold and elevate";
		default:
			return "";
		}
	}

}
