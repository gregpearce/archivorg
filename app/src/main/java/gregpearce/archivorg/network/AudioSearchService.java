package gregpearce.archivorg.network;

import javax.inject.Inject;
import javax.inject.Singleton;

import gregpearce.archivorg.model.ResultPage;
import rx.Observable;

@Singleton
public class AudioSearchService implements SearchService {

  private ArchiveOrgService archiveOrgService;

  @Inject AudioSearchService(ArchiveOrgService archiveOrgService) {
    this.archiveOrgService = archiveOrgService;
  }

  @Override public Observable<ResultPage> search(String query, int page) {
    final String videoFilter = " AND mediatype:(audio)";
    if (query.isEmpty()) {
      return archiveOrgService.search(ArchiveOrgService.TOP_QUERY + videoFilter, page, ArchiveOrgService.REVIEW_DATE_DESC);
    } else {
      return archiveOrgService.search(query + videoFilter, page, ArchiveOrgService.DOWNLOADS_DESC);
    }
  }
}