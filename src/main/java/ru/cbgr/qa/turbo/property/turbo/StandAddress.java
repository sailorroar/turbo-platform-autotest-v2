package ru.cbgr.qa.turbo.property.turbo;

/**
 * Константы основных стендов.
 * @author Evgeny Gribanov
 * @link egribanov@cbgr.ru
 * @since 08.07.2022 10:28
 */
public enum StandAddress {

  // remote
  REMOTE_SELENOID("172.17.117.11:4444", "SELENOID"),
  REMOTE_GRID("172.17.117.28:4444", "SELENIUM GRID"),

  // platform
  TEST("test.turbo.cbg.local/auto", "TEST"),
  DEV("dev.turbo.cbg.local/auto", "DEV"),
  TEST_LTS("lts-test.turbo.cbg.local/auto", "TEST_LTS"),
  LINUX("test-orel.turbo.cbg.local:25881/Auto", "LINUX"),
  RELEASE("release.turbo.cbg.local/auto", "RELEASE"),
  NEXT_TEST("172.17.117.25:98/auto", "NEXT_TEST"),
  NEXT_DEV("172.17.117.25:96/auto", "NEXT_DEV"),
  LOCAL_TEST("localhost:3000/auto", "LOCAL_TEST");

  private final String url;
  private final String standName;

  StandAddress(String url, String standName) {
    this.url = url;
    this.standName = standName;
  }

  public String getRemoteUrl() {
    return "http://" + url;
  }

  public String getUrl() {
    return "http://" + url + "/webui/index.html#/" ;
  }

  public String getStandName() {
    return standName;
  }

  public static String getStandUrl(String propertyName) {
    if (propertyName.equalsIgnoreCase(LINUX.standName)) return StandAddress.LINUX.getUrl();
    else if (propertyName.equalsIgnoreCase(DEV.standName)) return StandAddress.DEV.getUrl();
    else if (propertyName.equalsIgnoreCase(RELEASE.standName)) return StandAddress.RELEASE.getUrl();
    else if (propertyName.equalsIgnoreCase(NEXT_TEST.standName)) return StandAddress.NEXT_TEST.getUrl();
    else if (propertyName.equalsIgnoreCase(NEXT_DEV.standName)) return StandAddress.NEXT_DEV.getUrl();
    else if (propertyName.equalsIgnoreCase(LOCAL_TEST.standName)) return StandAddress.LOCAL_TEST.getUrl();
    else return StandAddress.TEST.getUrl();
  }
}