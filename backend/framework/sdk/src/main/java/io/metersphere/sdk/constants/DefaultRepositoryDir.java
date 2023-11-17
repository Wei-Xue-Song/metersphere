package io.metersphere.sdk.constants;

/**
 * @Author: jianxing
 * @CreateTime: 2023-11-17  14:04
 */
public class DefaultRepositoryDir {
    /**
     * 系统级别资源的根目录
     */
    private static final String SYSTEM_ROOT_DIR = "system";
    /**
     * 组织级别资源的项目目录
     * organization/{organizationId}
     */
    private static final String ORGANIZATION_DIR = "organization/%s";
    /**
     * 项目级别资源的项目目录
     * project/{projectId}
     */
    private static final String PROJECT_DIR = "project/%s";

    /*------ start: 系统下资源目录 ------*/

    /**
     * 插件存储目录
     */
    private static final String SYSTEM_PLUGIN_DIR = SYSTEM_ROOT_DIR + "/plugin";

    /*------ end: 系统下资源目录 --------*/



    /*------ start: 项目下资源目录 --------*/

    /**
     * 接口用例相关文件的存储目录
     * project/{projectId}/apiCase/{apiCaseId}
     */
    private static final String PROJECT_API_CASE_DIR = PROJECT_DIR + "/apiCase/%s";
    private static final String PROJECT_FUNCTIONAL_CASE_DIR = PROJECT_DIR + "/functionalCase/%s";
    private static final String PROJECT_FILE_MANAGEMENT_DIR = PROJECT_DIR + "/fileManagement";
    private static final String PROJECT_BUG_DIR = PROJECT_DIR + "/bug/%s";

    /*------ end: 项目下资源目录 --------*/


    public static String getApiCaseDir(String projectId, String apiCaseId) {
        return String.format(PROJECT_API_CASE_DIR, projectId, apiCaseId);
    }

    public static String getPluginDir() {
        return SYSTEM_PLUGIN_DIR;
    }

    public static String getFunctionalCaseDir(String projectId, String functionalCaseId) {
        return String.format(PROJECT_FUNCTIONAL_CASE_DIR, projectId, functionalCaseId);
    }

    public static String getFileManagementDir(String projectId) {
        return String.format(PROJECT_FILE_MANAGEMENT_DIR, projectId);
    }

    public static String getBugDir(String projectId, String bugId) {
        return String.format(PROJECT_BUG_DIR, projectId, bugId);
    }
}
