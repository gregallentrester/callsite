package net.greg.examples.callsite;

import net.greg.examples.webhook.delegate.SlackDelegate;


public final class Notifier {

  /**
   * Canonical entry-point for a
   * stand-alone Java application
   */
  public static void main(String[] words) {

    StringBuilder compositePayload =
      new StringBuilder(MEDIUM);

    System.err.println("\n\n Notifier fires ...\n\n");

    SlackDelegate.POST("BOM");

    for (int ndx=0; ndx < words.length; ndx++) {
      compositePayload.append(words[ndx] + " ");
    }

    // concatenation-ooerces-builder-2-String
    SlackDelegate.POST(compositePayload + "");

    SlackDelegate.POST("EOT");
  }


  private static final int SMALL = 10;
  private static final int MEDIUM = 100;
  private static final int LARGE = 1_000;
}
