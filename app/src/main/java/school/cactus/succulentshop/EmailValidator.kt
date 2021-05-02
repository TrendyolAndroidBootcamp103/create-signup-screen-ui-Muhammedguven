package school.cactus.succulentshop
class EmailValidator: Validator {
    override fun validate(field: String) = when {
        // !Patterns.EMAIL_ADDRESS.matcher(field).matches() is more useful!
        field.isEmpty() -> R.string.email_is_required
        !field.contains("@") || !field.contains(".") ||
                field.length < 5 || field.length > 50 -> R.string.email_is_invalid
        else -> null
    }
}