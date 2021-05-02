package school.cactus.succulentshop

class PasswordVerifyValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.this_field_is_required
        field.length<7 -> R.string.password_is_too_short
        field.length>40 -> R.string.password_is_too_long
        !field.contains(Regex("[0-9]")) -> R.string.at_least_one_digit
        !field.contains(Regex("[a-z]")) -> R.string.at_least_one_lowercase
        !field.contains(Regex("[A-Z]")) -> R.string.at_least_one_uppercase
        !field.contains(Regex("[^a-zA-Z0-9 ]")) -> R.string.at_least_one_special
        else -> null
    }
}