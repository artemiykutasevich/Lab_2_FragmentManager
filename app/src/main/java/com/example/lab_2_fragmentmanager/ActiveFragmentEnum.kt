package com.example.lab_2_fragmentmanager

import androidx.fragment.app.Fragment

enum class ActiveFragmentEnum(val fragment: Fragment) {
    authorization(AuthorizationFragment.newInstance()),
    account(AccountFragment.newInstance()),
    editAccount(EditAccountFragment.newInstance())
}