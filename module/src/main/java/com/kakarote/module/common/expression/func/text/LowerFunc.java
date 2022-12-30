package com.kakarote.module.common.expression.func.text;

import cn.hutool.core.util.StrUtil;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import com.kakarote.common.exception.BusinessException;
import com.kakarote.module.common.expression.ExpressionCategoryEnum;
import com.kakarote.module.common.expression.func.ICustomFunc;
import com.kakarote.module.constant.ModuleCodeEnum;

import java.util.Map;

/**
 * @author zjj
 * @title: LowerFunc
 * @description: LOWER
 * @date 2022/3/7 20:28
 */
public class LowerFunc extends AbstractFunction implements ICustomFunc {

    @Override
    public String getName() {
        return "LOWER";
    }

    @Override
    public ExpressionCategoryEnum getType() {
        return ExpressionCategoryEnum.TEXT;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
        try {
            String arg1Str = FunctionUtils.getStringValue(arg1, env);
            if (StrUtil.isEmpty(arg1Str)) {
                return null;
            }
            return new AviatorString((arg1Str.toLowerCase()));
        } catch (Exception e) {
            throw new BusinessException(ModuleCodeEnum.EXPRESSION_PARSE_ERROR);
        }
    }
}
