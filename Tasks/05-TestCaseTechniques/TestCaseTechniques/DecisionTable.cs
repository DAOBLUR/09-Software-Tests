// Ignore Spelling: Captcha

namespace TestCaseTechniques
{
    public class DecisionTable
    {
        public bool IsLoginSuccessful(bool isUsernameCorrect, bool isPasswordCorrect, bool isCaptchaCorrect)
        {
            return isUsernameCorrect && isPasswordCorrect && isCaptchaCorrect;
        }
    }
}