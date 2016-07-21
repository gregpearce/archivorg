package gregpearce.archivorg.network;

import java.util.List;

class SearchResponse {

  Response response;

  class Response {
    int numFound;
    int start;

    List<Doc> docs;

    class Doc {
      String identifier;
      String title;
      String description;
      String publicdate;
      String mediatype;
      String type;
    }
  }
}
