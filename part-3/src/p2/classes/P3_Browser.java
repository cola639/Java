package p2.classes;

public class P3_Browser {
  public void navigate(String address) {
    String ip = findIpAddress(address, true);
    String html = sendHttpRequest(ip);
    System.out.println(html);
  }

  private String sendHttpRequest(String ip) {
    return "<html></html>";
  }

  private String findIpAddress(String addresss, boolean cache) {
    return "127.0.0.1";
  }
}
