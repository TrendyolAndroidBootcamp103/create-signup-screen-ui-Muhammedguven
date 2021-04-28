package school.cactus.succulentshop

class UsernameValidator: Validator  {
    override fun validate(field: String) = when {
        // !Patterns.EMAIL_ADDRESS.matcher(field).matches() is more useful!
        field.isEmpty() -> R.string.username_is_required
        field.contains(Regex("[^a-z0-9_ ]")) -> R.string.username_not_consist_characters
        field.length<2 -> R.string.username_is_too_short
        field.length>20 -> R.string.username_is_too_long
        else -> null
    }
}