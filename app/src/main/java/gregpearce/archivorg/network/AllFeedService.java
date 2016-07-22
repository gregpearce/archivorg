package gregpearce.archivorg.network;

import javax.inject.Inject;
import javax.inject.Singleton;

import gregpearce.archivorg.model.ResultPage;
import rx.Observable;

@Singleton
public class AllFeedService implements FeedService {

  private ArchiveOrgFeedService archiveOrgFeedService;

  @Inject AllFeedService(ArchiveOrgFeedService archiveOrgFeedService) {
    this.archiveOrgFeedService = archiveOrgFeedService;
  }

  @Override public Observable<ResultPage> search(String query, int page) {
    if (query.isEmpty()) {
      return archiveOrgFeedService.search(ArchiveOrgFeedService.TOP_QUERY, page, ArchiveOrgFeedService.REVIEW_DATE_DESC);
    } else {
      return archiveOrgFeedService.search(query, page, ArchiveOrgFeedService.DOWNLOADS_DESC);
    }
  }
}