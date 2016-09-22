package gregpearce.archivorg.ui.discover;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import gregpearce.archivorg.ui.feed.FeedController;
import gregpearce.archivorg.ui.feed.FeedType;
import gregpearce.archivorg.util.BundleBuilder;

public class SearchController extends BaseDiscoverController {

  private static final String ARGUMENT_START_TAB = "ARGUMENT_START_TAB";
  private static final String ARGUMENT_QUERY = "ARGUMENT_QUERY";

  private final FeedType startTab;
  private final String query;

  public SearchController(FeedType startTab, String query) {
    this(BundleBuilder.create()
                      .putSerializable(ARGUMENT_START_TAB, startTab)
                      .putString(ARGUMENT_QUERY, query)
                      .build());
  }

  public SearchController(Bundle args) {
    super(args);
    startTab = (FeedType) args.getSerializable(ARGUMENT_START_TAB);
    query = args.getString(ARGUMENT_QUERY);
  }

  @Override protected FeedController getController(FeedType feedType) {
    return new FeedController(feedType);
  }

  @Override protected void onViewBound(@NonNull View view) {
    super.onViewBound(view);
    searchView.setShouldClearOnClose(false);
    searchView.setShouldClearOnOpen(false);
    searchView.setOnMenuClickListener(() -> getRouter().popController(this));
  }

  @Override protected void onAttach(@NonNull View view) {
    super.onAttach(view);
    // set the text in onAttach so that it is also reset when returning from backstack
    searchView.setTextInput(query);
  }
}