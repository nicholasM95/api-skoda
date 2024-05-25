terraform {
  required_providers {

    helm = {
      source  = "hashicorp/helm"
      version = "2.13.2"
    }

    cloudflare = {
      source  = "cloudflare/cloudflare"
      version = "4.33.0"
    }

    random = {
      source  = "hashicorp/random"
      version = "3.6.2"
    }

    vault = {
      source  = "hashicorp/vault"
      version = "4.2.0"
    }

    aws = {
      source  = "hashicorp/aws"
      version = "5.50.0"
    }
  }

  backend "s3" {
    bucket = "nicholasmeyers-api-skoda-prd-terraform-state"
    key    = "terraform.tfstate"
    region = "eu-west-1"
  }
}

provider "helm" {
  kubernetes {
    config_path = "~/.kube/config"
  }
}

provider "vault" {
}

provider "random" {
}
