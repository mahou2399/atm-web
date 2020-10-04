package csku.atm.controller;

import csku.atm.model.BankAccount;
import csku.atm.service.BankAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    private BankAccountService accountService;

    public BankAccountController(BankAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String getBankAccountPage(Model model) {
        model.addAttribute("bankaccounts", accountService.getBankAccounts());
        return "bankaccount";
    }

    @PostMapping
    public String openAccount(@ModelAttribute BankAccount bankAccount, Model model) {
        accountService.openAccount(bankAccount);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:bankaccount";
    }

//    @GetMapping("/edit/{id}")
//    public String getEditBankAccountPage(@PathVariable int id, Model model) {
//        BankAccount account = accountService.getBankAccount(id);
//        model.addAttribute("bankAccount", account);
//        return "bankaccount-edit";
//    }
//
//    @PostMapping("/edit/{id}")
//    public String editAccount(@PathVariable int id,
//                              @ModelAttribute BankAccount bankAccount,
//                              Model model) {
//
//        accountService.editBankAccount(bankAccount);
//        model.addAttribute("bankaccounts",accountService.getBankAccounts());
//        return "redirect:/bankaccount";
//    }

//    Delete
    @GetMapping("/delete/{id}")
    public String getDeleteBankAccountPage(@PathVariable int id, Model model) {
        BankAccount account = accountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        return "bankaccount-delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteAccount(@PathVariable int id,
                              @ModelAttribute BankAccount bankAccount,
                              Model model) {

        accountService.deleteBankAccount(bankAccount);
        return "redirect:/bankaccount";
    }
//    Delete

//    Deposit
    @GetMapping("/deposit/deposit-{id}")
    public String getDepositBankAccountPage(@PathVariable int id, Model model) {
        BankAccount account = accountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        return "bankaccount-deposit";
    }

    @PostMapping("/deposit/deposit-{id}")
    public String depositAccount(@PathVariable int id,
                              @ModelAttribute BankAccount bankAccount,
                              Model model) {

        accountService.depositBankAccount(bankAccount);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:/bankaccount";
    }
//    Deposit

//    Withdraw
    @GetMapping("/withdraw/withdraw-{id}")
    public String getWithdrawBankAccountPage(@PathVariable int id, Model model) {
        BankAccount account = accountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        return "bankaccount-withdraw";
    }

    @PostMapping("/withdraw/withdraw-{id}")
    public String withdrawAccount(@PathVariable int id,
                                 @ModelAttribute BankAccount bankAccount,
                                 Model model) {

        accountService.withdrawBankAccount(bankAccount);
        model.addAttribute("bankaccounts",accountService.getBankAccounts());
        return "redirect:/bankaccount";
    }
//    Deposit

}

