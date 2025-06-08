function open(msg) {
    const msgBox = document.getElementById("msg_box");
    const msgSpan = document.getElementById("msg");
    if (msgBox && msgSpan) {
        msgSpan.textContent = msg;
        msgBox.style.display = "block";
        setTimeout(() => {
            msgBox.style.display = "none";
        }, 2000);
    }
}

function diyConfirm(title, leftText, rightText, leftCallback, rightCallback) {
    const modal = document.getElementById("confirm");
    const modalContent = modal.querySelector(".confirm-content");
    const titleElem = document.getElementById("title");
    const leftBtn = document.getElementById("l_btn");
    const rightBtn = document.getElementById("r_btn");

    if (!modal || !modalContent || !titleElem || !leftBtn || !rightBtn) {
        console.error("Required elements not found");
        return;
    }

    // 设置内容
    titleElem.textContent = title || "确认审核";
    leftBtn.textContent = leftText || "通过";
    rightBtn.textContent = rightText || "拒绝";

    // 显示模态框
    modal.classList.add("show");
    console.log('Dialog shown, classList:', modal.classList.toString());
    
    // 阻止模态框内容的点击事件冒泡
    modalContent.onclick = function(e) {
        e.stopPropagation();
    };

    // 点击遮罩层关闭
    const closeModal = () => {
        modal.classList.remove("show");
        console.log('Dialog hidden, classList:', modal.classList.toString());
    };

    modal.onclick = function(e) {
        if (e.target === modal) {
            closeModal();
        }
    };

    // 按钮点击事件
    leftBtn.onclick = function(e) {
        e.stopPropagation();
        closeModal();
        if (typeof leftCallback === 'function') {
            leftCallback();
        }
    };

    rightBtn.onclick = function(e) {
        e.stopPropagation();
        closeModal();
        if (typeof rightCallback === 'function') {
            rightCallback();
        }
    };
}

document.querySelector('.confirm-content').addEventListener('click', function(e) {
    e.stopPropagation();
}); 