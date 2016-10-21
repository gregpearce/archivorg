package gregpearce.archivorg.ui.discover;

import gregpearce.archivorg.domain.model.FeedContentType;
import gregpearce.archivorg.ui.feed.FeedController;

class FeedTab {
  FeedController controller;
  String title;
  FeedContentType feedContentType;

  FeedTab(String title, FeedContentType feedContentType, FeedController controller) {
    this.controller = controller;
    this.title = title;
    this.feedContentType = feedContentType;
  }
}