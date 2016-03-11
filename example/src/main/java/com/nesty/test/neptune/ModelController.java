package com.nesty.test.neptune;

import org.nesty.commons.annotations.*;
import org.nesty.commons.constant.http.RequestMethod;
import org.nesty.core.httpserver.rest.HttpSession;
import org.nesty.example.httpserver.handler.model.ProjectModel;

import java.util.List;

@RequestMapping("/web/api")
@Controller
public class ModelController {
    /**
     * �����Ĵ��� ��ȡ�ӿ�. enum����
     */
    @RequestMapping(value = "/model/featureSettingEnum.json", method = RequestMethod.GET)
    public
    @ResponseBody
    ApiResult<Void> featureSettingEnumGet(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestParam(value = "modelId", required = false) Long modelId,
            @RequestParam(value = "featureId", required = false) Long featureId) {
        System.out.println(String.format("featureSettingEnumGet %d ", modelId));
        return new ApiResult<Void>();
    }

    /**
     * �����Ĵ��� ���ýӿ�. enum����
     */
    @RequestMapping(value = "/model/featureSettingEnum.json", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    ApiResult<Boolean> featureSettingEnumPost(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestBody ProjectModel featureSettingEnumVo) {
        System.out.println(String.format("featureSettingEnumGet %d ", projectId));
        return new ApiResult<Boolean>();
    }

    /**
     * �����Ĵ��� ��ȡ�ӿ�. numeric����
     */
    @RequestMapping(value = "/model/featureSettingNumeric.json", method = RequestMethod.GET)
    public
    @ResponseBody
    ApiResult<Void> featureSettingNumericGet(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestParam(value = "modelId", required = false) Long modelId,
            @RequestParam(value = "featureId", required = false) Long featureId) {
        System.out.println(String.format("featureSettingNumericGet %d ", modelId));
        return new ApiResult<Void>();
    }

    /**
     * �����Ĵ��� ���ýӿ�. numeric����
     */
    @RequestMapping(value = "/model/featureSettingNumeric.json", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    ApiResult<Boolean> featureSettingNumericPost(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestBody ProjectModel featureSettingNumericVo) {
        System.out.println(String.format("featureSettingNumericGet %d ", featureSettingNumericVo.getProjectId()));
        return new ApiResult<Boolean>();
    }

    /**
     * ģ�͵� ������ ���� չ�ֽӿ� ��������ݿ��е�json����ֱ�ӷ��ؼ���
     */
    @RequestMapping(value = "/model/featureAnalysis.json", method = RequestMethod.GET)
    public
    @ResponseBody
    ApiResult<Void> getModelFeatureAnalysis(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestParam(value = "modelId", required = false) Long modelId,
            @RequestParam(value = "featureId", required = false) Long featureId) {
        System.out.println(String.format("getModelFeatureAnalysist %d ", featureId));
        return new ApiResult<Void>();
    }

    /**
     * ģ�Ϳ�¡
     */
    @RequestMapping(value = "/model/clone.json", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    ApiResult<Long> clone(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestBody ProjectModel cloneModelVo) {
        System.out.println(String.format("getModelFeatureAnalysist %d ", projectId));
        return new ApiResult<Long>();
    }

    /**
     * ������
     */
    @RequestMapping(value = "/model/rename.json", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    ApiResult<Boolean> rename(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestParam(value = "modelId", required = false) Long modelId,
            @RequestParam(value = "modelName", required = false) String modelName,
            HttpSession httpSession) {
        System.out.println(String.format("getModelFeatureAnalysist %d requestId %s", projectId, httpSession.getId()));
        return new ApiResult<Boolean>();
    }

    /**
     * �������ļ���
     */
    @RequestMapping(value = "/model/renameFolder.json", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    ApiResult<Boolean> renameFolder(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestBody ProjectModel folderRenameVo, HttpSession httpSession) {
        System.out.println(String.format("renameFolder %d %s requestId %s", projectId, folderRenameVo.getProjectName(), httpSession.getId()));
        return new ApiResult<Boolean>();
    }

    /**
     * ���ܣ���ȡ��Ŀ�µ�ȫ��ģ��������Ϣ��.���� �ļ��к�ģ��. ������project id ����ֵ���������project�����е�ģ���б�
     */
    @RequestMapping(value = "/model/tree.json", method = RequestMethod.GET)
    public
    @ResponseBody
    ApiResult<List<Boolean>> getModelTree(
            @RequestParam(value = "projectId", required = false) final Long projectId,
            HttpSession httpSession) {
        System.out.println(String.format("getModelTree %d requestId %s", projectId, httpSession.getId()));
        return new ApiResult<List<Boolean>>();
    }

    /**
     * ���ܣ���ȡģ�͵���ϸ��Ϣ,ֻ��ȡģ�ͱ������Ϣ������ȡģ�������б� ģ�������б�ͨ����/model/featureList.json����ȡ
     * ������project id �� model id ����ֵ������ģ�͵���ϸ��Ϣ
     */
    @RequestMapping(value = "/model/detail.json", method = RequestMethod.GET)
    public
    @ResponseBody
    ApiResult<Boolean> getModelDetail(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestParam(value = "modelId", required = false) Long modelId, HttpSession httpSession) {
        System.out.println(String.format("getModelDetail %d %d requestId %s", projectId, modelId, httpSession.getId()));
        return new ApiResult<Boolean>();
    }

    /*
     * ���ܣ���ȡģ���б� ������ projectId:����id status��Ҫ��ѯ��ģ��״̬ pageSize��ÿһҳ��ʾ��ģ�͵�����
     * pageNum����ʾ��ҳ����� filterType��ɸѡ���� filterCondition�������ɾѡ������һ��Json��
     * orderField: �����ֶ� orderDirection�������� ����ֵ������ģ���б���Ϣ
     */
    @RequestMapping(value = "/model/list.json", method = RequestMethod.GET)
    public
    @ResponseBody
    ApiResult<Boolean> getModelList(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestParam(value = "status", required = false) Integer status,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "pageNum", required = false) Integer pageNum,
            @RequestParam(value = "filterType", required = false) Integer filterType,
            @RequestParam(value = "filterCondition", required = false) String filterCondition,
            @RequestParam(value = "orderField", required = false) String orderField,
            @RequestParam(value = "orderDirection", required = false) Boolean orderDirection,
            HttpSession httpSession) {
        System.out.println(String.format("getModelDetail %d %d requestId %s", projectId, pageSize, httpSession.getId()));
        return new ApiResult<Boolean>();
    }

    /*
     * ���ܣ���ȡģ��ѵ�����������Ϣ ������project id �� model id ����ֵ������ģ��ѵ���������
     */
    // ��ȡģ�͵�ѵ�������Ϣ����ʱ����һ��String����Ҫ����ϸ����
    @RequestMapping(value = "/model/report.json", method = RequestMethod.GET)
    public
    @ResponseBody
    ApiResult<Boolean> getModelReport(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestParam(value = "modelId", required = false) Long modelId, HttpSession httpSession) {
        System.out.println(String.format("getModelReport %d %d requestId %s", projectId, modelId, httpSession.getId()));
        return new ApiResult<Boolean>();
    }

    /**
     * ���ܣ��½�һ��model ������model��Ŀ¼id�� model���ƣ� modelʹ�õ��������ƣ�model��������Ŀ����
     * ����ֵ���½���model��id
     */
    @RequestMapping(value = "/model/create.json", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    ApiResult<Long> createModel(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestBody ProjectModel createModelParamVo, HttpSession httpSession) {
        System.out.println(String.format("createModel %d %d requestId %s", projectId, createModelParamVo.getProjectId(), httpSession.getId()));
        return new ApiResult<Long>();
    }

    /**
     * ���ܣ��½�һ��model���ļ��� ������nodeId���Ǹ��ļ��е�id,�����0���ǵ�һ�����ļ��� ����ֵ��boolean
     */
    @RequestMapping(value = "/model/createFolder.json", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    ApiResult<Boolean> createModelFolder(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestBody ProjectModel createModelParamVo, HttpSession httpSession) {
        System.out.println(String.format("createModelFolder %d %d requestId %s", projectId, createModelParamVo.getProjectId(), httpSession.getId()));
        return new ApiResult<Boolean>();
    }

    /**
     * ���ܣ�ɾ��һ��model������(��Ӧʵ���tree) ������project id�� model id ����ֵ��ɾ���ɹ����
     */
    @RequestMapping(value = "/model/deleteConfig.json", method = RequestMethod.POST)
    public
    @ResponseBody
    ApiResult<Boolean> deleteModelConfig(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestBody ProjectModel idWraperVo, HttpSession httpSession) {
        System.out.println(String.format("deleteModelConfig %d %d requestId %s", projectId, idWraperVo.getProjectId(), httpSession.getId()));
        return new ApiResult<Boolean>();
    }

    /**
     * ���ܣ�ɾ��һ��model��Ŀ¼, ��Ҫ�������������ȫɾ��.�еݹ���� ������project id�� model id ����ֵ��ɾ���ɹ����
     */
    @RequestMapping(value = "/model/deleteFolder.json", method = RequestMethod.POST)
    public
    @ResponseBody
    ApiResult<Boolean> deleteModelFolder(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestBody ProjectModel idWraperVo, HttpSession httpSession) {
        System.out.println(String.format("deleteModelFolderr %d %d requestId %s", projectId, idWraperVo.getProjectId(), httpSession.getId()));
        return new ApiResult<Boolean>();
    }

    /**
     * ���ܣ�ɾ��һ��model�ı���(��Ӧģ�͵��б�) ������project id�� model id ����ֵ��ɾ���ɹ����
     */
    @RequestMapping(value = "/model/deleteReport.json", method = RequestMethod.POST)
    public
    @ResponseBody
    ApiResult<Boolean> deleteModelReport(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestBody ProjectModel idWraperVo, HttpSession httpSession) {
        System.out.println(String.format("deleteModelReportr %d %d requestId %s", projectId, idWraperVo.getProjectId(), httpSession.getId()));
        return new ApiResult<Boolean>();
    }

    /**
     * ���ܣ�����model����Ϣ��������ģ��������Ϣ�� ������model����ز��� ����ֵ�����²����ɹ����ı�־
     */
    @RequestMapping(value = "/model/update.json", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    ApiResult<Boolean> updateModel(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestBody ProjectModel modelInfoVo, HttpSession httpSession) {
        System.out.println(String.format("updateModelr %d %d requestId %s", projectId, modelInfoVo.getProjectId(), httpSession.getId()));
        return new ApiResult<Boolean>();
    }

    /**
     * ���ܣ�����һ��ģ������ ������project id�� model id�� ģ������id ����ֵ�����������ɹ����ı�־
     */
    @RequestMapping(value = "/model/addFeature.json", method = RequestMethod.POST)
    public
    @ResponseBody
    ApiResult<Boolean> addModelFeature(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestBody ProjectModel addFeatureVo, HttpSession httpSession) {
        System.out.println(String.format("addModelFeaturer %d %d requestId %s", projectId, addFeatureVo.getProjectId(), httpSession.getId()));
        return new ApiResult<Boolean>();
    }

    /**
     * ɾ��ģ�� �� ɾ��ģ�ͱ��� �Ƿֱ�ɾ����,����Ӱ����ʾ ���ܣ�ɾ��һ��ģ������ ������project id�� model id�� model
     * feature id ����ֵ��ɾ�������ɹ����ı�־
     */
    @RequestMapping(value = "/model/deleteFeature.json", method = RequestMethod.POST)
    public
    @ResponseBody
    ApiResult<Boolean> deleteModelFeature(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestBody ProjectModel modelFeatureIdVo, HttpSession httpSession) {
        System.out.println(String.format("deleteModelFeaturer %d %d requestId %s", projectId, modelFeatureIdVo.getProjectId(), httpSession.getId()));
        return new ApiResult<Boolean>();
    }

    /**
     * ���ܣ���ȡģ�������б� ������ projectId:����id modelId��ģ��id pageSize��ÿһҳ��ʾ��ģ�͵�����
     * pageNum����ʾ��ҳ����� orderField: �����ֶ� orderDirection�������� ����ֵ������ģ�������б���Ϣ
     */
    @RequestMapping(value = "/model/featureList.json", method = RequestMethod.GET)
    public
    @ResponseBody
    ApiResult<Boolean> getModelFeatureList(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestParam(value = "modelId", required = false) Long modelId,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "pageNum", required = false) Integer pageNum,
            @RequestParam(value = "orderField", required = false) String orderField,
            @RequestParam(value = "orderDirection", required = false) Boolean orderDirection,
            HttpSession httpSession) {
        System.out.println(String.format("getModelFeatureList %d %d requestId %s", projectId, pageNum, httpSession.getId()));
        return new ApiResult<Boolean>();
    }

    /**
     * ���ܣ����´���һ��ģ���µ���������(��ʼ�� �� ����Ĵ���) ������project id�� model id ����ֵ��ɾ���ɹ����
     */
    @RequestMapping(value = "/model/dealModelAllFeature.json", method = RequestMethod.POST)
    public
    @ResponseBody
    ApiResult<Boolean> dealModelAllFeature(
            @RequestParam(value = "projectId", required = false) Long projectId,
            @RequestBody ProjectModel idWraperVo, HttpSession httpSession) {
        System.out.println(String.format("dealModelAllFeature %d %d requestId %s", projectId, idWraperVo.getProjectId(), httpSession.getId()));
        return new ApiResult<Boolean>();
    }

    @RequestMapping(value = "/model/brief-detail.json", method = RequestMethod.GET)
    public
    @ResponseBody
    ApiResult<Boolean> getModelReportSettingDetail(
            HttpSession httpSession,
            @RequestParam(value = "projectId", required = true) Long projectId,
            @RequestParam(value = "modelId", required = true) Long modelId) {
        System.out.println(String.format("getModelReportSettingDetail %d %d requestId %s", projectId, modelId, httpSession.getId()));
        return new ApiResult<Boolean>();
    }

}