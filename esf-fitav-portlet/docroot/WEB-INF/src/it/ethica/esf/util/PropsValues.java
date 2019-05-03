package it.ethica.esf.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;


public class PropsValues {

	public static final int PASSWORDS_DEFAULT_POLICY_MIN_LENGTH = GetterUtil.getInteger(PropsUtil.get(PropsKeys.PASSWORDS_DEFAULT_POLICY_MIN_LENGTH));

	public static final long PASSWORDS_DEFAULT_POLICY_MIN_AGE = GetterUtil.getLong(PropsUtil.get(PropsKeys.PASSWORDS_DEFAULT_POLICY_MIN_AGE));

	public static final boolean USERS_REMINDER_QUERIES_ENABLED = GetterUtil.getBoolean(PropsUtil.get(PropsKeys.USERS_REMINDER_QUERIES_ENABLED));

	public static final boolean USERS_REMINDER_QUERIES_CUSTOM_QUESTION_ENABLED = GetterUtil.getBoolean(PropsUtil.get(PropsKeys.USERS_REMINDER_QUERIES_CUSTOM_QUESTION_ENABLED));

	public static final String[] USERS_REMINDER_QUERIES_QUESTIONS = PropsUtil.getArray(PropsKeys.USERS_REMINDER_QUERIES_QUESTIONS);

	
}